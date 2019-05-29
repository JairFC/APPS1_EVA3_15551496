package jairfranco.com.tec2.pfran.eva3_16_media_player_servicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent inMultimedia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inMultimedia  = new Intent(this,ServicioMultimedia.class);
    }

    public void iniciar(View v){
        startService(inMultimedia);
    }
    public void detener(View v){
        stopService(inMultimedia);
    }
}
