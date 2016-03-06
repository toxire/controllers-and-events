package com.theamalgama.controllersproject.simplecontrollerwithevents;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.theamalgama.controllersproject.R;
import com.theamalgama.event.EventManager;
import com.theamalgama.event.listeners.EventNotifierListener;

public class SimpleControllerWithEventActivity extends Activity {

    private TextViewController textViewController;

    private EventManager eventManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Create instance of controller
        textViewController = new TextViewController(this, (TextView) findViewById(R.id.activity_main_textview));

        //Create an eventManager and set it
        eventManager = new EventManager(this);
        textViewController.setEventHandlerListener(eventManager);

        eventManager.addEventNotifierListener(new EventNotifierListener() {
            @Override
            public void onTextClicked() {
                Log.w("SimpleControllerWithEventActivity", "Event of type SimpleControllerWithEventsTextViewClickEvent found");
            }
        });
    }
}
