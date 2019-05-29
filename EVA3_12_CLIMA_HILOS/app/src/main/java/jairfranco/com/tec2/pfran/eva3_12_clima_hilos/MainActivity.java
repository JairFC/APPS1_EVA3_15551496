package jairfranco.com.tec2.pfran.eva3_12_clima_hilos;

import android.app.Application;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener{



    List<Clima> lstCiudades = new ArrayList<Clima>();

     ListView llCiudades;
//    Clima[] acClimaCd= {
//
//            new Clima(R.drawable.light_rain,"Delicias","Soleado","Seco y polvoriento",19.5),
//            new Clima(R.drawable.thunderstorm,"Entre Rios","Nublado","Tormenta Electrica",67),
//            new Clima(R.drawable.rainy,"Cuahutemoc","LLuvioso","Nublado con intervalos",17.4),
//            new Clima(R.drawable.tornado,"Camargo","Tornado","The day after tomorrow",47),
//            new Clima(R.drawable.atmospher,"Santa Barbara","LLuvioso","Parcialmente Nublado",27),
//            new Clima(R.drawable.cloudy,"Juarez","LLuvioso","Nublado con intervalos",37)
//
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionClima coClimaCiudad  = new ConexionClima();
        llCiudades = findViewById(R.id.listCiud);
        coClimaCiudad.execute();

//        lstCiud = findViewById(R.id.listCiud);
//        lstCiud.setAdapter(new ClimaAdapter(this,R.layout.layout_clima,acClimaCd));
//        lstCiud.setOnItemClickListener(this);

    }

     class ConexionClima extends AsyncTask<Void,Void,String>{
        //CONEXION, RECIBIR LOS DATOS COMO CADENA
        //EN FORMATO JSON

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (!s.equals("")){
                //RECIBIMOS DATOS


                try {
                    JSONObject jsDatos = new JSONObject(s);
                    JSONArray ajsCiudades = jsDatos.getJSONArray("list");
                    for (int i =0; i<ajsCiudades.length(); i++){
                        JSONObject jsActual = ajsCiudades.getJSONObject(i);
                        Clima cCiudad = new Clima();

                        cCiudad.setCiudad(jsActual.getString("name"));

                        JSONObject jsMain = jsActual.getJSONObject("main");
                        cCiudad.setTemp(jsMain.getDouble("temp"));

                        JSONArray ajsClimas = jsActual.getJSONArray("weather");
                        JSONObject jsClima = ajsClimas.getJSONObject(0);
                        cCiudad.setClima(jsClima.getString("main"));

                        cCiudad.setDesc_clima(jsClima.getString("description"));


                        int iId = jsClima.getInt("id");
                        if (iId < 300){//TORMENTAS
                            cCiudad.setImgClima(R.drawable.thunderstorm);
                        }else if(iId<400){//LLUVIA LIGERA
                            cCiudad.setImgClima(R.drawable.light_rain);
                        }else if(iId<600){//LLUVIA INTENSA
                            cCiudad.setImgClima(R.drawable.rainy);
                        }else if(iId<700){//NIEVE
                            cCiudad.setImgClima(R.drawable.snow);
                        }else if(iId<800){//FENOMENO ATMOSFERICO
                            cCiudad.setImgClima(R.drawable.atmospher);
                        }else if(iId<801){//DESPEJADO
                            cCiudad.setImgClima(R.drawable.sunny);
                        }else if(iId<900){//NUBLADO
                            cCiudad.setImgClima(R.drawable.cloudy);
                        }else{//CORRAN POR SUS VIDAS
                            cCiudad.setImgClima(R.drawable.tornado);
                        }

                        lstCiudades.add(cCiudad);

                    }

                    //MOSTRAMOS TODOO ALV
                    llCiudades.setAdapter(new ClimaAdapter(MainActivity.this,R.layout.layout_clima,lstCiudades));


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }


        //LEER ESA CADENA Y LLENAR LA LSTA
        @Override
        protected String doInBackground(Void... voids) {
            String sUrl = "https://samples.openweathermap.org/data/2.5/find?lat=55.5&lon=37.5&cnt=10&appid=b6907d289e10d714a6e88b30761fae22";
            String sResu = "";

            try {
                URL url = new URL(sUrl);
                HttpsURLConnection httpCon = (HttpsURLConnection) url.openConnection();
                if (httpCon.getResponseCode() == HttpsURLConnection.HTTP_OK){
                    //BUFFERED READER INPUTSTREAMREADER
                    BufferedReader brDatosJSON = new BufferedReader(
                            new InputStreamReader(httpCon.getInputStream())
                    );
                    sResu = brDatosJSON.readLine();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sResu;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(this, acClimaCd[position].getDesc_clima()+"", Toast.LENGTH_SHORT).show();
    }
}


