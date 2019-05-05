package com.example.qichaoqun.amerilink.NetWork;

import java.io.IOException;

import okhttp3.Request;

public interface ResultCallback {
    public abstract void onError(Request request, Exception e);
    public abstract void onResponse(String str) throws IOException;
}
