package de.christinecoenen.code.zapp.app.settings.ui;


import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import de.christinecoenen.code.zapp.R;
import de.christinecoenen.code.zapp.app.settings.helper.ShortcutPreference;

/**
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends PreferenceFragmentCompat {

	private static final String PREF_SHORTCUTS = "pref_shortcuts";

	/**
	 * Use this factory method to create a new instance of
	 * this fragment.
	 */
	static SettingsFragment newInstance() {
		return new SettingsFragment();
	}

	private ShortcutPreference shortcutPreference;

	public SettingsFragment() {
		// required empty public constructor
	}

	@Override
	public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
		addPreferencesFromResource(R.xml.preferences);

		shortcutPreference = (ShortcutPreference) getPreferenceScreen()
			.findPreference(PREF_SHORTCUTS);
	}

	@Override
	public void onResume() {
		super.onResume();
		shortcutPreference.setOnPreferenceChangeListener(shortcutPreference);
	}

	@Override
	public void onPause() {
		super.onPause();
		shortcutPreference.setOnPreferenceChangeListener(null);
	}
}
