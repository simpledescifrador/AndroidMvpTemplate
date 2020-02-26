package com.eapps.androidmvptemplate.ui.main;

import android.os.Bundle;
import butterknife.ButterKnife;
import com.eapps.androidmvptemplate.R;
import com.eapps.androidmvptemplate.ui.base.BaseActivity;
import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityFragmentComponent().inject(this);
        mPresenter.attachView(this);
        setContentView(R.layout.activity_main);
        setUnBinder(ButterKnife.bind(this));
        init();
        //NO UI CODE HERE PROCEED TO INIT()
    }

    @Override
    protected void init() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
