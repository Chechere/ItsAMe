package com.chechere.itsame;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.RemoteViews;

/**
 * Proveedor que gestiona la logica de un Widget que muestra imagenes sencillas
 */
public class ItsAMeWidget extends AppWidgetProvider {
    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        int imageResId = getImageRes(context);

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.its_a_me_widget);
        views.setImageViewResource(R.id.widgetImage, imageResId);

        Intent intent = new Intent(context, ImagePickerActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                context,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );

        views.setOnClickPendingIntent(R.id.widgetImage, pendingIntent);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    /**
     * Recoge la imagen que quiere mostrarse actualmente
     * @param context Contexto en el que se encuentra el Widget
     * @return El ID de la imagen ó, por defecto, -1
     */
    private static int getImageRes(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(
                context.getResources().getString(R.string.prefs_name),
                Context.MODE_PRIVATE
        );

        int selectedImage = prefs.getInt(
                context.getResources().getString(R.string.pref_selected_image),
                -1
        );

        return IMAGES.getImage(selectedImage);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them

        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }
}