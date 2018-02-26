package findarrow.rian.andre.com.br.findarrow;

import android.content.Context;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by user on 22/02/2018.
 */

public class ImageViewJogo extends android.support.v7.widget.AppCompatImageView {
    private String tipoBotao;
    private int nivelBotao;
    public ImageViewJogo(Context context) {
        super(context);
    }

    public  String getTipoBotao (){
        return  this.tipoBotao;
    }

    public  void setTipoBotao (String tipoBotao){
        this.tipoBotao = tipoBotao;
    }

    public  int getNivelBotao (){
        return  this.nivelBotao;
    }

    public  void setNivelBotao(int nivelBotao){
        this.nivelBotao = nivelBotao;
    }

    public ArrayList<ImageViewJogo> geraListaImageView(int [] arrayIdImageview, Context context, boolean imagemGif){

        ArrayList<ImageViewJogo> listaImageView = new ArrayList<>();
        for (int i=0; i< arrayIdImageview.length; i++) {
            ImageViewJogo imagemView = new ImageViewJogo(context);
            imagemView.setId(i);

            if(imagemGif)
                Glide.with(context).load(arrayIdImageview[i]).asGif().into(imagemView);
            else
               imagemView.setImageResource(arrayIdImageview[i]);

            imagemView.setEnabled(false);
            listaImageView.add(imagemView);

        }


        return listaImageView;
    }

    /*public  void definirNivesGridView(GridView gridView, ArrayList<ImageViewJogo> listaImageView){
        int qtdColunas = gridView.getNumColumns();
        int qtdImageView = listaImageView.size();
        if(qtdColunas == 0){
            return;
           Log.e("Erro", "quantidade de colunas nao pode ser Zero!");
        }
        int qdtLinha = qtdImageView/qtdColunas;

    }*/
}
