package com.krazy.bee;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.krazy.bee.fragments.AlbumPhotos;
import com.krazy.bee.network.NetworkInstance;
import com.krazy.bee.network.models.albums.Album;
import com.krazy.bee.utils.ProgressView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private AlbumPhotos albumPhotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        ProgressView.showProgressDialog(this);
        NetworkInstance.getInstance().getAlbums().enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ProgressView.closeProgressDialog();
                final List<Album> albums = response.body();
                viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
                    @Override
                    public int getCount() {
                        return albums.size();
                    }

                    @Override
                    public Fragment getItem(int position) {
                        albumPhotos = new AlbumPhotos();
                        albumPhotos.setMyAlbumId(albums.get(position).id);
                        return albumPhotos;
                    }

                    @Override
                    public CharSequence getPageTitle(int position) {
                        return albums.get(position).title;
                    }
                });
                tabLayout.setupWithViewPager(viewPager);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                ProgressView.closeProgressDialog();
            }
        });
    }

}
