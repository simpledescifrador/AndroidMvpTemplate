package com.eapps.androidmvptemplate.di.module;

import android.app.Activity;
import com.eapps.androidmvptemplate.di.scope.ActivityScope;
import com.eapps.androidmvptemplate.utils.PermissionUtil;
import dagger.Module;
import dagger.Provides;

@Module
public class UtilityModule {
    private Activity mActivity;

    public UtilityModule(final Activity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityScope
    PermissionUtil providePermissionUtils() {
        return new PermissionUtil(mActivity);
    }
}
