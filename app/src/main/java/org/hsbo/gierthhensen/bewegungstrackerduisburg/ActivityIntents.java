package org.hsbo.gierthhensen.bewegungstrackerduisburg;

import android.content.Intent;
import android.app.IntentService;
import android.support.v4.content.LocalBroadcastManager;

import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;

import java.util.ArrayList;

/**
 * @author Lukas Gierth and Matthias Hensen
 * Internal Service for activity recognition. Does only send intents.
 */
public class ActivityIntents extends IntentService{

    private static final String BROADCAST_ACTIVITY = "gierthhensen.hsbo.org.bewegungstrackerduisburg.BROADCAST_ACTIVITY";
    private static final String DATA_ACTIVITY = "gierthhensen.hsbo.org.bewegungstrackerduisburg.DATA_ACTIVITY";


    public ActivityIntents() {
        super("ActivityIntents");
    }

    /**
     * Handles the incoming intents and sends the detected activity in a new intent.
     * @param intent
     */
    @Override
    protected void onHandleIntent(Intent intent) {
        ActivityRecognitionResult result = ActivityRecognitionResult.extractResult(intent);
        Intent lIntent = new Intent(BROADCAST_ACTIVITY);

        ArrayList<DetectedActivity> detectedActivities = (ArrayList) result.getProbableActivities();

        lIntent.putExtra(DATA_ACTIVITY, detectedActivities);
        LocalBroadcastManager.getInstance(this).sendBroadcast(lIntent);
    }
}
