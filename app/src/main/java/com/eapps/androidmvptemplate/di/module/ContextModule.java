package com.eapps.androidmvptemplate.di.module;

import android.content.Context;
import com.eapps.androidmvptemplate.di.qualifier.ApplicationContext;
import com.eapps.androidmvptemplate.di.scope.ApplicationScope;
import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private Context mContext;

    public ContextModule(final Context context) {
        mContext = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    Context provideContext() {
        return mContext;
    }
}
