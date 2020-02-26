package com.eapps.androidmvptemplate.data.preference;

import javax.inject.Inject;

public class AppPreferenceHelper implements PreferenceHelper {

    private CommonPreferenceHelper mCommonPreferenceHelper;

    @Inject
    public AppPreferenceHelper(final CommonPreferenceHelper commonPreferenceHelper) {
        mCommonPreferenceHelper = commonPreferenceHelper;
    }
}
