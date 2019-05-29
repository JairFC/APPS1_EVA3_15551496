package jairfranco.com.tec2.pfran.eva3_12_clima_hilos;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class ClimaAdapter extends ArrayAdapter<Clima> {

    private Context cApp;
    private int iMiLay;
    private List<Clima> acDatos;

    public ClimaAdapter(@NonNull Context context, int resource,List objects) {
        super(context, resource, objects);

        cApp = context;
        iMiLay = resource;
        acDatos = objects;
    }



    @NonNull
    @Override
    public View getView(int position, View convertView,@NonNull ViewGroup parent) {
        ImageView imgClim;
        TextView txtCd,txtTemp,txtClima,txtDesc;

        View vwMiLay = convertView;

        if (vwMiLay == null){//no existe  la fila hay que crearla
            LayoutInflater liCrearLay = ((Activity) cApp).getLayoutInflater();
            vwMiLay = liCrearLay.inflate(iMiLay, parent, false);
        }

        imgClim = vwMiLay.findViewById(R.id.imageClima);
        txtCd = vwMiLay.findViewById(R.id.txtvciud);
        txtClima = vwMiLay.findViewById(R.id.txtclim);
        txtDesc = vwMiLay.findViewById(R.id.txtvdesc);
        txtTemp = vwMiLay.findViewById(R.id.txtvtemp);

        Clima cClimaCd= acDatos.get(position);

        imgClim.setImageResource(cClimaCd.getImgClima());
        txtCd.setText(cClimaCd.getCiudad());
        txtClima.setText(cClimaCd.getClima());
        txtDesc.setText(cClimaCd.getDesc_clima());
        txtTemp.setText(cClimaCd.getTemp()+"°F");

        return vwMiLay;
    }
}
