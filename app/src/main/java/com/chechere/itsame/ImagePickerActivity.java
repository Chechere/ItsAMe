package com.chechere.itsame;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

/**
 * Actividad con un selector sencillo de imagenes
 */
public class ImagePickerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] titles = getResources().getStringArray(R.array.titles);

        AlertDialog.Builder builder = new AlertDialog.Builder(this,
                                                        androidx.appcompat.R.style.Theme_AppCompat);

        builder.setTitle(R.string.img_selector_title);

        builder.setItems(titles, (dialog, which) ->  {
            SharedPreferences prefs = getSharedPreferences(
                    getResources().getString(R.string.prefs_name),
                    MODE_PRIVATE
            );

            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt(getResources().getString(R.string.pref_selected_image), which);
            editor.apply();

            updateWidget();

            finish();
        });

        AlertDialog ad = builder.create();

        ad.show();
    }

    /**
     * Avisa a todos los widgets activos actualizar su imagen.
     */
    private void updateWidget() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(
                new ComponentName(
                        this,
                        ItsAMeWidget.class
                )
        );

        for (int appWidgetId : appWidgetIds) {
            ItsAMeWidget.updateAppWidget(this, appWidgetManager, appWidgetId);
        }
    }
}
