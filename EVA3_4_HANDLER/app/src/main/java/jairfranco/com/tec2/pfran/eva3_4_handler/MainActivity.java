package jairfranco.com.tec2.pfran.eva3_4_handler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt1;
    final int HILO_CHAFA = 1000;
    final int HILO_CHAFA2 = 10;

    Handler hMiHandler = new Handler(){
        //PERTENECE AL HILO PRINCIPAL
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            //PUEDEN INTERACTUAL CON LA INTERFAZ GRAFICA


           int iVal = (int) msg.obj;
            txt1.setText("HILO  = " + msg.what+ ","+" contador = "+iVal);

        }
    };

    Thread rHilo = new Thread(){
        @Override
        public void run() {
            super.run();
            int iCont=0;

            while (true){

                Message message = hMiHandler.obtainMessage(HILO_CHAFA2,iCont++);
                hMiHandler.sendMessage(message);
                iCont++;

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    };

    Thread rHilo2 = new Thread(){
        @Override
        public void run() {
            super.run();
            int iCont=0;

            while (true){
                Message message = hMiHandler.obtainMessage(HILO_CHAFA2,iCont++);
                hMiHandler.sendMessage(message);
                iCont++;

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = findViewById(R.id.txtview1);

        Thread tHilo = new Thread(rHilo);
        Thread tHilo2 = new Thread(rHilo2);

        tHilo.start();
        tHilo2.start();
    }
}
