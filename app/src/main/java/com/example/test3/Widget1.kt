package com.example.test3

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.RemoteViews



//lauot android:background="@color/material_dynamic_primary90"
// textwiew android:background="#FFEB3B"
/**
 * Implementation of App Widget functionality.
 * App Widget Configuration implemented in [Widget1ConfigureActivity]
 */
class Widget1 : AppWidgetProvider() {
    @SuppressLint("RemoteViewLayout")
    override fun onUpdate(
            context: Context,
            appWidgetManager: AppWidgetManager,
            appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            val pendingIntent: PendingIntent = PendingIntent.getActivity(
                context, 0, Intent(
                    context,
                    first::class.java
                ), PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
            val views: RemoteViews = RemoteViews(
                context.packageName,
                R.layout.widget1
            ).apply { setOnClickPendingIntent(R.id.widgetButton, pendingIntent) }
            appWidgetManager.updateAppWidget(appWidgetId, views)
            //updateAppWidget(context, appWidgetManager, appWidgetId)
            loguj("On00Update: End1")
        }
        loguj("On00Update: End2")
    }
//*88888888888888888888888888888888888888888888



//*88888888888888888888888888888888888888888888
    override fun onDeleted(context: Context, appWidgetIds: IntArray) {
        // When the user deletes the widget, delete the preference associated with it.
        for (appWidgetId in appWidgetIds) {
            deleteTitlePref(context, appWidgetId)
        }
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)
        loguj("OnRecive: End")
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

@SuppressLint("RemoteViewLayout")
internal fun updateAppWidget(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int
) {
    val widgetText = loadTitlePref(context, appWidgetId)
    // Construct the RemoteViews object
    //val views1 = RemoteViews(context.packageName, R.layout.widget1)
    val vidge1 = RemoteViews(context.packageName, R.layout.widget1)
    //val views2 = RemoteViews(context.packageName, R.layout.widget1)
   val views3 = RemoteViews(context.packageName, R.layout.widget1)
    //val views4 = RemoteViews(context.packageName, R.layout.widget1)
    //val zmienna45 = spalone5
    //views.setTextViewText(R.id.appwidget_text, widgetText)
    //views.setTextViewText(R.id.appwidget_text, widgetText.plus(spalone5))
    vidge1.setTextViewText(R.id.widgettxt2, spalone5)
   // vidge1.setTextViewText(R.id.widgetTest2.toString())
    vidge1.setTextViewText(R.id.widgettxt2.toString())
    loguj ("updateAppWidget: spalone5: $spalone5")
    //val btn = findViewById<Button> (R.id.add_button)
    val btn = RemoteViews(context.packageName, R.layout.widget1)
    btn.setTextViewText(R.id.widgetButton, widgetText.plus("cos"))
    //views3.setTextViewText(R.id.widgetTest3, widgetText)
    //findViewById<Button>(R.id.statystyki_btn_back)
    //btn.setOnClickPendingIntent(R.id.widgetButton, PendingIntent(context, "increse"))

    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, vidge1)
//val btnklik =
//    btn.setOnClickListener()
//    {
//        spaloneNonVisible()
//    }
    loguj("Update: End")

}

private fun RemoteViews.setTextViewText(toString: String) {

}

//private fun PendingIntent(context: Context?, action: String): PendingIntent?
//{loguj("PendingIntent: start")
//    var intent = Intent(context, java.class))
//                //intent.
//            intent.action = action
//
//                return PendingIntent.getBroadcast(context, 0, intent,
//                    PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_MUTABLE));
//
//
//}

fun loguj(s: String) {
    Log.d("Widget", s)
}