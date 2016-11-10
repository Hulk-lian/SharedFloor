package com.jtsw.sharedfloor.settings;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.jtsw.sharedfloor.R;

public class GeneralSetting_activity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.general_setting);
    }
}
