package com.eapps.androidmvptemplate.di.module;

import android.app.Application;
import android.content.Context;
import com.eapps.androidmvptemplate.data.AppDataManager;
import com.eapps.androidmvptemplate.data.DataManager;
import com.eapps.androidmvptemplate.data.db.DbHelper;
import com.eapps.androidmvptemplate.data.network.ApiHelper;
import com.eapps.androidmvptemplate.data.preference.PreferenceHelper;
import com.eapps.androidmvptemplate.di.qualifier.ApplicationContext;
import com.eapps.androidmvptemplate.di.scope.ApplicationScope;
import dagger.Module;
import dagger.Provides;

@Module(includes = {ContextModule.class, PreferenceModule.class, RetrofitModule.class, DatabaseModule.class})
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationScope
    static AppDataManager provideAppDataManager(@ApplicationContext Context context,
            PreferenceHelper preferencesHelper,
            DbHelper dbHelper,
            ApiHelper apiHelper) {
        return new AppDataManager(context, dbHelper, preferencesHelper, apiHelper);
    }

    @Provides
    @ApplicationScope
    static DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }
}
