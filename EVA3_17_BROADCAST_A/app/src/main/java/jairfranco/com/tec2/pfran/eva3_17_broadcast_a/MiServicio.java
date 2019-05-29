package jairfranco.com.tec2.pfran.eva3_17_broadcast_a;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MiServicio extends Service {
    Thread tHilo;
    Intent inMensaje;

    public MiServicio() {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        inMensaje = new Intent("MI_SERVICIO");
        inMensaje.putExtra("MENSAJE","onDestroy");
        sendBroadcast(inMensaje);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        tHilo = new Thread(){
            @Override
            public void run() {
                super.run();
                while (true){
                    try {
                        Thread.sleep(1000);
                        Intent i = new Intent("MI_SERVICIO");
                        i.putExtra("MENSAJE","onStart");
                        sendBroadcast(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
