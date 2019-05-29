package jairfranco.com.tec2.pfran.eva3_17_broadcast_b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtVwDatos;
    BroadcastReceiver brReceptor;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtVwDatos = findViewById(R.id.txtVwDatos);


        brReceptor = new MiBroadCast();

        //DECIRLE AL BROADCAST QUE SERVIIO DEBE ESCUCHAR
        IntentFilter ifMiServicio = new IntentFilter("MI_SERVICIO");
        registerReceiver(brReceptor,ifMiServicio);
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
