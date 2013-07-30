package com.tech_tec.qiitarian.fragment.content.tags.http;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import android.annotation.SuppressLint;
import com.tech_tec.qiitarian.model.http.ClientBase;
import com.tech_tec.qiitarian.model.tags.UrlName;

public class TagsClient extends ClientBase {
    
    private UrlName mUrlName;
    private int mPage;
    
    public TagsClient(UrlName urlName, int page) {
        mUrlName = urlName;
        mPage = page;
    }
    
    @Override @SuppressLint("DefaultLocale")
    protected HttpUriRequest createRequest() {
        String url = String.format("/api/v1/users/%s/following_tags?page=%d", mUrlName.toString(), mPage);
        return new HttpGet(url);
    }
    
}
