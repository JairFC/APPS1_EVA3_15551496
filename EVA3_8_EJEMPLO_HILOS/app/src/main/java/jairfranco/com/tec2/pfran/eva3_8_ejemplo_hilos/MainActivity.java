package jairfranco.com.tec2.pfran.eva3_8_ejemplo_hilos;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    Bitmap bImage;
    Handler hHandler = new Handler();
    Runnable rRunUI= new Runnable() {
        @Override
        public void run() {
            //AQUI VAMOS A MOSTRAR LA IMAGEN
            img.setImageBitmap(bImage);
        }
    };
    Thread tHilo = new Thread(){
        @Override
        public void run() {
            super.run();
            //AQUI VAMOS A CARGAR LA IMAGEN
            bImage = cargarImagen("https://vignette.wikia.nocookie.net/gameofthrones/images/1/1f/801_Winterfell_Overview.png/revision/latest?cb=20190415031728");
            hHandler.post(rRunUI);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img= findViewById(R.id.imagenMost);
        tHilo.start();
    }


    private Bitmap cargarImagen(String url){

        try {
            InputStream inputStream = null;
            inputStream = (InputStream) new URL(url).getContent();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
