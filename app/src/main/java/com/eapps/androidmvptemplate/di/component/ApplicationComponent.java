package com.eapps.androidmvptemplate.di.component;

import android.content.Context;
import com.eapps.androidmvptemplate.MainApplication;
import com.eapps.androidmvptemplate.data.DataManager;
import com.eapps.androidmvptemplate.di.module.ApplicationModule;
import com.eapps.androidmvptemplate.di.qualifier.ApplicationContext;
import com.eapps.androidmvptemplate.di.scope.ApplicationScope;
import dagger.Component;

@ApplicationScope
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    @ApplicationContext
    Context getContext();

    DataManager getDataManager();

    void inject(MainApplication application);
}
