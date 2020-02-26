package com.eapps.androidmvptemplate.di.module;

import android.content.Context;
import com.eapps.androidmvptemplate.data.preference.AppPreferenceHelper;
import com.eapps.androidmvptemplate.data.preference.CommonPreferenceHelper;
import com.eapps.androidmvptemplate.data.preference.PreferenceHelper;
import com.eapps.androidmvptemplate.di.qualifier.ApplicationContext;
import com.eapps.androidmvptemplate.di.scope.ApplicationScope;
import dagger.Module;
import dagger.Provides;

@Module
public class PreferenceModule {

    @Provides
    @ApplicationScope
    static PreferenceHelper provideApplicationPreference(CommonPreferenceHelper commonPreferenceHelper) {
        return new AppPreferenceHelper(commonPreferenceHelper);
    }

    @Provides
    @ApplicationScope
    static CommonPreferenceHelper providePreferencesHelper(@ApplicationContext Context context) {
        return new CommonPreferenceHelper(context);
    }
}
