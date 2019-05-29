package jairfranco.com.tec2.pfran.eva3_1_thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    Thread miHilo = new Thread(){
        @Override
        public void run() {
            super.run();

            for (int i=0; i<20 ; i++){
                try {
                    Log.wtf("Hilo",i+"");
                    Thread.sleep(500);
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

        miHilo.start();

//        for (int i=0; i<20 ; i++){
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
