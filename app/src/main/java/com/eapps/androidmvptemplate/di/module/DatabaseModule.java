package com.eapps.androidmvptemplate.di.module;

import com.eapps.androidmvptemplate.data.db.AppDbHelper;
import com.eapps.androidmvptemplate.data.db.DbHelper;
import com.eapps.androidmvptemplate.di.scope.ApplicationScope;
import dagger.Module;
import dagger.Provides;

@Module(includes = {ContextModule.class, RoomModule.class})
public class DatabaseModule {
    @Provides
    @ApplicationScope
    static DbHelper provideDbHelper() {
        return new AppDbHelper();
    }
}
