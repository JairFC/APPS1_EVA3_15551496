package jairfranco.com.tec2.pfran.eva3_16_media_player_servicio;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class ServicioMultimedia extends Service {

    MediaPlayer mMultimedia = null;

    public ServicioMultimedia() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mMultimedia = MediaPlayer.create(getApplicationContext(),R.raw.stars);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if (mMultimedia !=null){
            mMultimedia.start();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mMultimedia !=null){
            mMultimedia.stop();
            mMultimedia.release();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
