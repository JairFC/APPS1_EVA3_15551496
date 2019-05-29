package jairfranco.com.tec2.pfran.eva3_2_enable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {


    Thread Thilo;

    Runnable run1 = new Runnable() {
        @Override
        public void run() {


            while (true) {


                for (int i = 0; i < 20; i++) {
                    try {
                        Log.wtf("Hilo", i + "");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thilo = new Thread(run1);
        Thilo.start();
    }


    @Override
    protected void onStop() {
        super.onStop();
        Thilo.interrupt();
    }
}
