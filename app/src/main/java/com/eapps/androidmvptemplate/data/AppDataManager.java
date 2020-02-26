package com.eapps.androidmvptemplate.data;

import android.content.Context;
import com.eapps.androidmvptemplate.data.db.DbHelper;
import com.eapps.androidmvptemplate.data.network.ApiHelper;
import com.eapps.androidmvptemplate.data.preference.PreferenceHelper;
import com.eapps.androidmvptemplate.di.qualifier.ApplicationContext;
import javax.inject.Inject;

public class AppDataManager implements DataManager {

    private final Context mContext;

    private final DbHelper mDbHelper;

    private final PreferenceHelper mPreferenceHelper;

    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context, final DbHelper dbHelper,
            final PreferenceHelper preferenceHelper, final ApiHelper apiHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferenceHelper = preferenceHelper;
        mApiHelper = apiHelper;
    }
}
