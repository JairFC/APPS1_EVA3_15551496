package jairfranco.com.tec2.pfran.eva3_5_handler;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtVwMensa;

    Handler hMiHandler  = new Handler();

    Runnable rRunInterfaz = new Runnable() {
        @Override
        public void run() {
            //AQUI SI PODEMOS INTERACTUAR CON LA UI

            txtVwMensa.append("");
        }
    };


    Thread tHiloPal = new Thread(){

        @Override
        public void run() {
            super.run();
            while (true){
                try {
                    Thread.sleep(500);
                    hMiHandler.;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtVwMensa = findViewById(R.id.txtMesa);
        tHiloPal.start();
    }




}
