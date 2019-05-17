package com.example.bakingapp;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

public class WidgetViewFactory implements RemoteViewsService.RemoteViewsFactory {

    private Context context=null;
    private int appWidgetId;

    public WidgetViewFactory(Context ctx, Intent intent) {
        this.context=ctx;
        appWidgetId=intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID);
    }

    @Override
    public void onCreate() {
        // no-op
    }

    @Override
    public void onDestroy() {
        // no-op
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews row=new RemoteViews(context.getPackageName(), R.layout.ingredient_app_widget);

        SharedPreferences preferences = context.getSharedPreferences(context.getString(R.string.pref_file_name), Context.MODE_PRIVATE);

        row.setTextViewText(R.id.widget_ingredient, preferences.getString(context.getString(R.string.widget_ingredients),"You have not opened any receipts yet."));

        return(row);
    }

    @Override
    public RemoteViews getLoadingView() {
        return(null);
    }

    @Override
    public int getViewTypeCount() {
        return(1);
    }

    @Override
    public long getItemId(int position) {
        return(position);
    }

    @Override
    public boolean hasStableIds() {
        return(true);
    }

    @Override
    public void onDataSetChanged() {
      getViewAt(0);
    }
}