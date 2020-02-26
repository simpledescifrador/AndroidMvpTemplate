package com.eapps.androidmvptemplate.data;

import com.eapps.androidmvptemplate.data.db.DbHelper;
import com.eapps.androidmvptemplate.data.network.ApiHelper;
import com.eapps.androidmvptemplate.data.preference.PreferenceHelper;

public interface DataManager extends DbHelper, PreferenceHelper, ApiHelper {

}
