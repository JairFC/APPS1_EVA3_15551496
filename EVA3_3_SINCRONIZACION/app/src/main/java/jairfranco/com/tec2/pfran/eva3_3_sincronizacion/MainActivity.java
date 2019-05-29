package jairfranco.com.tec2.pfran.eva3_3_sincronizacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt1;

    Thread tHilo = new Thread(){
        @Override
        public void run() {
            super.run();
            while (true){
                txt1.setText("MODIFICADO POR EL HILO");
                try {
                    Thread.sleep(1000);
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
        txt1.setText("AQUI NO HAY PROBLEMA");
        tHilo.start();
    }
}
