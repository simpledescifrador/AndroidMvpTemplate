package com.eapps.androidmvptemplate.ui.main;

import com.eapps.androidmvptemplate.data.DataManager;
import com.eapps.androidmvptemplate.ui.base.BasePresenter;
import javax.inject.Inject;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

    @Inject
    MainPresenter(final DataManager dataManager) {
        super(dataManager);
    }
}
