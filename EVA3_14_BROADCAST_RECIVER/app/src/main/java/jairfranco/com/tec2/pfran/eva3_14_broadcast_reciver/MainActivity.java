package jairfranco.com.tec2.pfran.eva3_14_broadcast_reciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Intent inMiServicio;
    TextView txtVwDatos;
    BroadcastReceiver brReceptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtVwDatos = findViewById(R.id.textViewDatos);

        inMiServicio= new Intent(this,MiServicio.class);

        brReceptor = new MiBroadCast();

        //DECIRLE AL BROADCAST QUE SERVIIO DEBE ESCUCHAR
        IntentFilter ifMiServicio = new IntentFilter("MI_SERVICIO");
        registerReceiver(brReceptor,ifMiServicio);


    }
    public void onClickIni(View v){
        startService(inMiServicio);
    }
    public void onClickDetener(View v){
        stopService(inMiServicio);
    }

    class MiBroadCast extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            //AQUI INTERPRETAMOS LOS DATOS
            //PONRT LOS DATOS EN EL TEXTVIEW

            String sCade  = intent.getStringExtra("MENSAJE");
            txtVwDatos.append(sCade+" \n ");
        }
    }
}
