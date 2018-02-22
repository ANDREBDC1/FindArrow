package findarrow.rian.andre.com.br.findarrow.adaptador;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by user on 21/02/2018.
 */

public class Adaptador extends BaseAdapter {

    private Context context;
    private int [] lista;

    public  Adaptador(Context context , int[] lista){

        this.context = context;
        this.lista = lista;

    }
    @Override
    public int getCount() {
        return lista.length;
    }

    @Override
    public Object getItem(int position) {
        return lista[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView ib = new ImageView(context);
        ib.setImageResource(lista[position]);
        ib.setAdjustViewBounds(true);
        return ib;
    }
}
