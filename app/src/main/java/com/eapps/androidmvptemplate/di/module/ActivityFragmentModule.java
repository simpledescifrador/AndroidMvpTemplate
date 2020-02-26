package com.eapps.androidmvptemplate.di.module;

import android.app.Activity;
import android.content.Context;
import com.eapps.androidmvptemplate.di.qualifier.ActivityContext;
import com.eapps.androidmvptemplate.di.scope.ActivityScope;
import com.eapps.androidmvptemplate.ui.main.MainMvpPresenter;
import com.eapps.androidmvptemplate.ui.main.MainMvpView;
import com.eapps.androidmvptemplate.ui.main.MainPresenter;
import dagger.Module;
import dagger.Provides;

@Module(includes = {AdapterModule.class, RxModule.class, UtilityModule.class})
public class ActivityFragmentModule {

    private Activity mActivity;

    public ActivityFragmentModule(final Activity activity) {
        mActivity = activity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityContext
    Context provideActivityContext() {
        return mActivity;
    }

    @Provides
    @ActivityScope
    static MainMvpPresenter<MainMvpView> provideMainPresenter(MainPresenter<MainMvpView> presenter) {
        return presenter;
    }
}
