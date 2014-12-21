package com.jiechic.mvp.util;

import com.jiechic.mvp.util.net.SurveyWebURI;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class SurveyWebHttpClient {
    private AsyncHttpClient client;

    public SurveyWebHttpClient() {
        this.client = new AsyncHttpClient();
    }

    public void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(new SurveyWebURI(url).getAbsoluteUrl(), params, responseHandler);
    }

    public void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(new SurveyWebURI(url).getAbsoluteUrl(), params, responseHandler);
    }
}
