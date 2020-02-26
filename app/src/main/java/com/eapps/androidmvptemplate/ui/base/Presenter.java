package com.eapps.androidmvptemplate.ui.base;

import androidx.annotation.NonNull;

public interface Presenter<V> {
    /**
     * Called when the view is attached to the presenter. Presenters should normally not use this
     * method since it's only used to link the view to the presenter which is done by the
     * BasePresenter.
     *
     * @param mvpView the view
     */
    void attachView(@NonNull V mvpView);

    /**
     * Called when the view is detached from the presenter. Presenters should normally not use this
     * method since it's only used to unlink the view from the presenter which is done by the
     * BasePresenter.
     */
    void detachView();
}
