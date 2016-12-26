package com.tcl.selfstartservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new IMyAidlManager();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public class IMyAidlManager extends IMyAidlInterface.Stub{

        @Override
        public void setVal(int value) throws RemoteException {

        }

        @Override
        public int getVal() throws RemoteException {
            return 0;
        }
    }
}
