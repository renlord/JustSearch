package co.pxhouse.sas.android.provider

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import co.pxhouse.sas.R
import co.pxhouse.sas.android.activity.AssistActivity

class HomescreenWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(context: Context?, appWidgetManager: AppWidgetManager?, appWidgetIds: IntArray?) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)

        val appWidgetLayout = RemoteViews(context?.packageName, R.layout.widget)
        val intent = Intent(context, AssistActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context,0, intent, 0)

        appWidgetLayout.setOnClickPendingIntent(R.id.analogClock, pendingIntent)
        appWidgetIds?.let {
            for (appWidgetId in it) {
                appWidgetManager?.updateAppWidget(appWidgetId, appWidgetLayout)
            }
        }
    }
}

