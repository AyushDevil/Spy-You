package com.fourthstatelab.spy_you;

import android.app.ActivityManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActivityManager am = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcessInfo = am.getRunningAppProcesses();
        List<Process> pro=new ArrayList<>();
        for(int i=0;i<runningAppProcessInfo.size();i++)
        {

            ActivityManager.RunningAppProcessInfo r=runningAppProcessInfo.get(i);

            if(r.processName.contains("com.android.")==false &&r.processName.contains("com.google.")==false && r.processName.contains("com.mediatek.")==false && r.processName.contains("android.")==false)
            {
                Process p=new Process();
                p.name=r.processName;
                p.time= Calendar.HOUR_OF_DAY+":"+Calendar.MINUTE;
                pro.add(p);
            }
        }

        for(int i=0;i<pro.size();i++)
        {
            Toast.makeText(this, pro.get(i).name, Toast.LENGTH_SHORT).show();
        }





    }


}

class Process
{
    String name;
    String time;
}
