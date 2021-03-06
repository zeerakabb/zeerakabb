/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.accentype.android.softkeyboard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;

import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import com.android.inputmethodcommon.InputMethodSettingsFragment;

import java.util.ArrayList;

/**
 * Displays the IME preferences inside the input method setting.
 */

public class ImePreferences extends PreferenceActivity {
    private SharedPreferences settings;
    private static final String keyVibration = "toggleVibrate";
    private static final String cancelKey = "toggleCancelKey";


    private static final boolean defaultVibration = true;
    private static final boolean defaultCancelKey = false;


    @Override
    public Intent getIntent() {
        final Intent modIntent = new Intent(super.getIntent());
        modIntent.putExtra(EXTRA_SHOW_FRAGMENT, Settings.class.getName());
        modIntent.putExtra(EXTRA_NO_HEADERS, true);
        return modIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            setTitle(R.string.settings_name);
            settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    }



    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = settings.edit();
        boolean vibrationValue = settings.getBoolean(keyVibration, defaultVibration);
        boolean cancelKeyValue = settings.getBoolean(cancelKey, defaultCancelKey);
        editor.putBoolean(keyVibration, vibrationValue);
        editor.putBoolean(cancelKey, cancelKeyValue);
        editor.commit();

    }

    @Override
    protected boolean isValidFragment(String fragmentName) {
        // TODO: the right way of fixing the crash is to do the following:
        // return [YOUR_FRAGMENT_NAME_HERE].class.getName().equals(fragmentName);
        return true;
    }



    public static class Settings extends InputMethodSettingsFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setInputMethodSettingsCategoryTitle(R.string.language_selection_title);
            setSubtypeEnablerTitle(R.string.select_language);

            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.ime_preferences);
        }
    }
}
