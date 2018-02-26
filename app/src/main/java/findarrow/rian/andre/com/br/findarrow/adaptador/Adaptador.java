package findarrow.rian.andre.com.br.findarrow.adaptador;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import findarrow.rian.andre.com.br.findarrow.ImageViewJogo;

/**
 * Created by user on 21/02/2018.
 */

public class Adaptador extends BaseAdapter {


    private ArrayList<ImageViewJogo> listaImageViews;

    public  Adaptador(ArrayList<ImageViewJogo> listaImageViews){

        this.listaImageViews = listaImageViews;

    }
    @Override
    public int getCount() {
        return listaImageViews.size();
    }

    @Override
    public Object getItem(int position) {
        return listaImageViews.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaImageViews.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView ib = listaImageViews.get(position);
        ib.setAdjustViewBounds(true);
        return ib;
    }
}
