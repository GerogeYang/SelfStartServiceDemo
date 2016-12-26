package com.tcl.selfstartservicedemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnStart,btnStop,btnBind,btnUnBind;
    private Intent service;
    private  ServiceConnection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnStart = (Button) findViewById(R.id.start);
        btnStop = (Button) findViewById(R.id.stop);
        btnBind = (Button) findViewById(R.id.bind);
        btnUnBind = (Button) findViewById(R.id.unbind);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnBind.setOnClickListener(this);
        btnUnBind.setOnClickListener(this);
        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Toast.makeText(MainActivity.this,"绑定成功！",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:
                Log.i("YJ---->","开启服务");
                service = new Intent(MainActivity.this,MyService.class);
                startService(service);
                break;
            case R.id.stop:
                Log.i("YJ---->","停止服务");
                stopService(service);
                break;
            case R.id.bind:
                Log.i("YJ---->","绑定服务");
                service = new Intent(MainActivity.this,MyService.class);
                bindService(service, connection, Context.BIND_AUTO_CREATE);
                break;
            case R.id.unbind:
                Log.i("YJ---->","解绑服务");
                unbindService(connection);
                break;
        }
    }
}
