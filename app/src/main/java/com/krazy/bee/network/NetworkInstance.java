package com.krazy.bee.network;


import com.krazy.bee.interfaces.iNetworkOperation;

public class NetworkInstance {
    private static iNetworkOperation network;

    private NetworkInstance() {}

    public static iNetworkOperation getInstance() {
        network = RetroFitInstance.getInstance().create(iNetworkOperation.class);
        return network;
    }

}

