package jairfranco.com.tec2.pfran.eva3_13_servicios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent inMiServicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inMiServicio= new Intent(this,MiServicio.class);
    }


    public void onClickIni(View v){
        startService(inMiServicio);
    }
    public void onClickDetener(View v){
        stopService(inMiServicio);
    }
}
