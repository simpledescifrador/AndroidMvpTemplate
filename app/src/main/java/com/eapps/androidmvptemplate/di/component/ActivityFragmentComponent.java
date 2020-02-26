package com.eapps.androidmvptemplate.di.component;

import com.eapps.androidmvptemplate.di.module.ActivityFragmentModule;
import com.eapps.androidmvptemplate.di.scope.ActivityScope;
import com.eapps.androidmvptemplate.ui.main.MainActivity;
import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = ActivityFragmentModule.class)
public interface ActivityFragmentComponent {
    void inject(MainActivity activity);
}
