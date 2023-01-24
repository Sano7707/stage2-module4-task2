package com.mjc.stage2.impl;


import com.mjc.stage2.Connection;

public class ProxyConnection implements Connection {
    private RealConnection realConnection;

    public ProxyConnection(RealConnection realConnection) {
        this.realConnection = realConnection;
    }

    public void reallyClose() {
        // Write your code here!
        realConnection.close();
    }

    @Override
    public void close() {
        ConnectionPool con = ConnectionPool.getInstance();
        con.destroyPool();
        realConnection.close();
    }

    @Override
    public boolean isClosed() {
        return realConnection.isClosed();
    }
    // Implement methods here!
}
