package com.eapps.androidmvptemplate.data.network;

import javax.inject.Inject;

public class AppApiHelper implements ApiHelper {
    private ApiInterface mApiInterface;

    @Inject
    public AppApiHelper(final ApiInterface apiInterface) {
        mApiInterface = apiInterface;
    }
}
