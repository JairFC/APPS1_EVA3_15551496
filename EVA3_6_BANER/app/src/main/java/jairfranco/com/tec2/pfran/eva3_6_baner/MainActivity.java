package jairfranco.com.tec2.pfran.eva3_6_baner;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {


    ImageView img;
    SeekBar skBrSpeed;
    int iImagen =0;

    int[] aiImagenes ={

            R.drawable.aaa,
            R.drawable.bbb,
            R.drawable.ccc,
            R.drawable.ddd,
            R.drawable.eee,
            R.drawable.fff
    };

    Handler handler = new Handler();

    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            img.setImageResource(aiImagenes[iImagen]);
            if (iImagen==3){
                iImagen=0;
            }else{
                iImagen++;
            }

        }
    };


    Thread tHilo = new Thread(){
        @Override
        public void run() {
            super.run();
            while (true){
                try {
                    Thread.sleep(1000);
                    handler.post(runnable);
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

        img = findViewById(R.id.img);
        skBrSpeed = findViewById(R.id.seek);
        tHilo.start();
    }
}
