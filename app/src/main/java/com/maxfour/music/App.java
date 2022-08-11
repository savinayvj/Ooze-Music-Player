package com.maxfour.music;

import android.app.Application;
import android.os.Build;

import com.google.android.material.color.DynamicColors;
import com.kabouzeid.appthemehelper.ThemeStore;
import com.maxfour.music.appshortcuts.DynamicShortcutManager;

public class App extends Application {

    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        if(true){
            DynamicColors.applyToActivitiesIfAvailable(this);
        } else {
            // default theme
            if (!ThemeStore.isConfigured(this, 1)) {
                ThemeStore.editTheme(this)
                        .primaryColorRes(R.color.primary_color)
                        .accentColorRes(R.color.accent_color)
                        .commit();
            }
        }

        // Set up dynamic shortcuts
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            new DynamicShortcutManager(this).initDynamicShortcuts();
        }
    }

    public static App getInstance() {
        return app;
    }
}
