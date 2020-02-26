package com.eapps.androidmvptemplate.ui.base;

import android.app.ProgressDialog;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import butterknife.Unbinder;
import com.eapps.androidmvptemplate.MainApplication;
import com.eapps.androidmvptemplate.R;
import com.eapps.androidmvptemplate.di.component.ActivityFragmentComponent;
import com.eapps.androidmvptemplate.di.component.DaggerActivityFragmentComponent;
import com.eapps.androidmvptemplate.di.module.ActivityFragmentModule;
import com.eapps.androidmvptemplate.di.module.UtilityModule;
import com.eapps.androidmvptemplate.utils.AppUtils;

public abstract class BaseActivity extends AppCompatActivity implements BaseMvpView {

    private ActivityFragmentComponent mActivityFragmentComponent;

    private ProgressDialog mProgressDialog;

    private Unbinder mUnbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityFragmentComponent = DaggerActivityFragmentComponent.builder()
                .activityFragmentModule(new ActivityFragmentModule(this))
                .utilityModule(new UtilityModule(this))
                .applicationComponent(MainApplication.getApplicationComponent())
                .build();
    }

    @Override
    protected void onDestroy() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroy();
    }

    public ActivityFragmentComponent getActivityFragmentComponent() {
        return mActivityFragmentComponent;
    }

    @Override
    public void hideKeyboard() {
        AppUtils.hideKeyboard(this);
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    @Override
    public boolean isNetworkConnected() {
        return AppUtils.isNetworkAvailable(getApplicationContext());
    }

    @Override
    public void onError(@StringRes int resId) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnbinder = unBinder;
    }

    public void showBackButton(boolean shouldShow) {
        if (getSupportActionBar() != null) {
            Drawable backArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_material);
            backArrow.setColorFilter(ContextCompat.getColor(this, android.R.color.white),
                    PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(backArrow);
            getSupportActionBar().setHomeButtonEnabled(shouldShow);
            getSupportActionBar().setDisplayHomeAsUpEnabled(shouldShow);
        }
    }

    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = AppUtils.showLoadingDialog(this);
    }

    protected abstract void init();
}
