package com.example.a06dialogpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SensoresActivity extends AppCompatActivity {
    private TextView tvProximidad, tvGiroscopio = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores);

        tvProximidad = findViewById(R.id.tvProximidad);
        tvGiroscopio = findViewById(R.id.tvGiroscopio);
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        final Sensor proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if (proximitySensor == null) {
            Log.e("sensor", "No existe el sensor de Proximidad");
        }
        SensorEventListener proximitySensorListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent.values[0] < proximitySensor.getMaximumRange()) {
                    tvProximidad.setText("Cerca");
                } else {
                    tvProximidad.setText("Lejos");
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

        final Sensor giroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if (giroscopeSensor == null) {
            Log.e("sensor", "No existe el sensor del Giroscopio");
        }
        SensorEventListener giroscopeSensorListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                Log.d("sensor", sensorEvent.values[2]+"");
                if (sensorEvent.values[2] > 0.5f) {
                    tvGiroscopio.setText("Izquierda");
                } else {
                    tvGiroscopio.setText("Derecha");
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        sensorManager.registerListener(giroscopeSensorListener, giroscopeSensor, 2 * 1000 * 1000);
        sensorManager.registerListener(proximitySensorListener, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
}