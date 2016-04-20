package com.santiago.controllersproject.simplecontrollerwithevents;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.santiago.controllers.BaseController;
import com.santiago.event.anotation.AsyncMethod;
import com.santiago.event.anotation.EventMethod;

/**
 * Created by santi on 08/01/16.
 */
public class TextViewViewController extends BaseController<TextView> {

    public TextViewViewController(Context context) {
        super(context);
    }

    @Override
    protected void onElementAttached(TextView textView) {
        textView.setText("TextViewViewController Test");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                broadcastEvent(new SimpleControllerWithEventsTextViewClickEvent());
            }
        });
    }

    @AsyncMethod
    @EventMethod(SimpleControllerWithEventsTextViewClickEvent.class)
    private void someMethodThatTriggersThatEvent() {
        Log.w("TextViewViewController", "Event of type SimpleControllerWithEventsTextViewClickEvent found, event has no params");
        Log.w("TextViewViewController", "This is being called from thread " + Thread.currentThread().getName());
    }

}
