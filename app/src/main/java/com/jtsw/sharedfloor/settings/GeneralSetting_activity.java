package com.jtsw.sharedfloor.settings;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;

import com.jtsw.sharedfloor.ListTypeElement;
import com.jtsw.sharedfloor.R;

public class GeneralSetting_activity extends PreferenceActivity {

    private Preference typeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.general_setting);

    }
}
