package com.tcl.selfstartservicedemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    private static final String ACTION = "android.intent.action.BOOT_COMPLETED";

    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        if (intent.getAction().equals(ACTION)){
            Intent service = new Intent(context,MyService.class);
            context.startService(service);
            System.out.println("YJ----->: selfStartService");
        }

    }
}
