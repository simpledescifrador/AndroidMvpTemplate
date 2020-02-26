package com.eapps.androidmvptemplate;

import android.app.Application;
import com.eapps.androidmvptemplate.di.component.ApplicationComponent;
import com.eapps.androidmvptemplate.di.component.DaggerApplicationComponent;
import com.eapps.androidmvptemplate.di.module.ApplicationModule;
import com.eapps.androidmvptemplate.di.module.ContextModule;
import com.eapps.androidmvptemplate.di.module.RoomModule;

public class MainApplication extends Application {

    public static ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initApplicationDaggerComponent();
    }
    public static ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    private void initApplicationDaggerComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .contextModule(new ContextModule(this))
                .roomModule(new RoomModule(this))
                .build();

        mApplicationComponent.inject(this);
    }
}
