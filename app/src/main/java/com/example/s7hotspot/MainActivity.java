package com.example.s7hotspot;
import android.app.*;import android.os.*;import android.Manifest;import android.content.*;import android.content.pm.PackageManager;import android.widget.*;
public class MainActivity extends Activity {
 TextView status;
 @Override public void onCreate(Bundle b){super.onCreate(b);LinearLayout l=new LinearLayout(this);l.setOrientation(1);l.setPadding(28,35,28,20);status=new TextView(this);status.setText("S7 LocalOnlyHotspot\nEnable Location in Settings first.\nKeep this app running.");l.addView(status);Button start=new Button(this);start.setText("Start hotspot + web server");l.addView(start);Button stop=new Button(this);stop.setText("Stop");l.addView(stop);setContentView(l);
 start.setOnClickListener(v->{if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);return;}startService(new Intent(this,HotspotService.class).setAction("START"));status.setText("Starting... check notification / adb logcat -s S7Hotspot");});
 stop.setOnClickListener(v->startService(new Intent(this,HotspotService.class).setAction("STOP")));
 }
}
