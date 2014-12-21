package com.jiechic.mvp.util.net;


import com.jiechic.mvp.exceptions.SurveyWebURIException;

import java.net.URI;
import java.net.URISyntaxException;

public class SurveyWebURI {
    URI baseURI;
    URI path;

    public SurveyWebURI(String pathString) {
        try {
            baseURI = new URI("http://staging.thesurveys.org/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            path = new URI(pathString);
        } catch (URISyntaxException e) {
            throw new SurveyWebURIException(e.getMessage());
        }
    }

    public String getAbsoluteUrl() {
        return baseURI.resolve(path).toString();
    }
}