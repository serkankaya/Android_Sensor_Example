package com.yesilfil.androidsensorproject;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends Activity implements SensorEventListener{
    float x , y , z;
    TextView textx,texty,textz;
    SensorManager sm = null;
    Button serkan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textx = (TextView) findViewById(R.id.TextX);
        texty = (TextView)findViewById(R.id.TextY);
        textz = (TextView)findViewById(R.id.TextZ);
        serkan=(Button)findViewById(R.id.serkan);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), sm.SENSOR_DELAY_NORMAL);

    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
// TODO Auto-generated method stub
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
// TODO Auto-generated method stub
        if (event.sensor.getType()==Sensor.TYPE_ACCELEROMETER) {
            textx.setText("X : "+Float.toString(event.values[0]));
            texty.setText("Y : "+Float.toString(event.values[1]));
            textz.setText("Z : "+Float.toString(event.values[2]));
            serkan.animate().translationX(event.values[0]*25*(-1)).setDuration(0).setStartDelay(0);
            serkan.animate().translationY(event.values[1]*40).setDuration(0).setStartDelay(0);
        }
    }
}
