package findarrow.rian.andre.com.br.findarrow;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import findarrow.rian.andre.com.br.findarrow.adaptador.Adaptador;
import findarrow.rian.andre.com.br.findarrow.gera_numero_aleatorio.GeraRandom;

public class MainActivity extends Activity  implements ImageViewJogo.OnClickListener{

    int []  img;

    int [] idImgJogo = new int[]{R.drawable.seta,R.drawable.bomba,R.drawable.vida,R.drawable.premio};

    ArrayList<ImageViewJogo> listaImageView = new ArrayList<>();

    private static  final int NIVEL_BT1 = 1;
    private static  final int NIVEL_BT2 = 2;
    private static  final int NIVEL_BT3 = 3;
    private static  final int NIVEL_BT4 = 4;
    private static  final int NIVEL_BT5 = 5;

    private static  final String BOMBA = "BOMBA";
    private static  final String SETA = "SETA";
    private static  final String VIDA = "VIDA";
    private static final  String PREMIO = "PREMIO";


    String tipoBotoes[] = new String[]{BOMBA,BOMBA,BOMBA,SETA,VIDA};

    GridView gridView;
    private static int CONT_VIDA = 1;
    private static int PERDEU = 0;
    private static int PONTOS = 0;

    EditText txtVida, txtPontos;


    public MainActivity() {
        img = new int[]{R.drawable.tenor,R.drawable.tenor,R.drawable.tenor,R.drawable.tenor,R.drawable.tenor,
                R.drawable.tenor,R.drawable.tenor,R.drawable.tenor,R.drawable.tenor,R.drawable.tenor,R.drawable.tenor,
                R.drawable.tenor,R.drawable.tenor,R.drawable.tenor,R.drawable.tenor,R.drawable.tenor,R.drawable.tenor,
                R.drawable.tenor,R.drawable.tenor,R.drawable.tenor,R.drawable.tenor,R.drawable.tenor,R.drawable.tenor,
                R.drawable.tenor,R.drawable.tenor};
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridViewId);
        txtVida = (EditText) findViewById(R.id.editTextVidaId);
        txtPontos =(EditText) findViewById(R.id.editTextPontosId);
        txtVida.setText(""+CONT_VIDA);
        txtPontos.setText(""+PONTOS);

        preencherListaImageView();
        setImagemGridView();
        gridView.smoothScrollToPosition(24);


    }

    private void setImagemGridView() {
        Adaptador adp = new Adaptador(listaImageView);
        gridView.setAdapter(adp);
    }

    private void preencherListaImageView() {

        txtVida.setText(""+CONT_VIDA);
        txtPontos.setText(""+PONTOS);
        ImageViewJogo imgView;
        for(int i =0; i < img.length; i++){
            imgView = new ImageViewJogo(this);
            Glide.with(this).load(img[i]).asGif().into(imgView);
            imgView.setId(i);
            imgView.setEnabled(false);
            imgView.setOnClickListener(this);
            listaImageView.add( imgView );

        }

        defineNivel();

    }

    private void defineNivel() {


        for(int i=0; i < 5; i++){
            listaImageView.get(i).setTipoBotao(BOMBA);
            listaImageView.get(i).setNivelBotao(NIVEL_BT5);
        }

        listaImageView.get(GeraRandom.geraNumeroEntre(0,4)).setTipoBotao(PREMIO);

        int pos =0;
        Collections.shuffle(Arrays.asList(tipoBotoes));
        for(int i=5; i < 10; i++){
            listaImageView.get(i).setTipoBotao(tipoBotoes[pos]);
            listaImageView.get(i).setNivelBotao(NIVEL_BT4);
            pos++;
        }

        pos =0;
        Collections.shuffle(Arrays.asList(tipoBotoes));
        for(int i=10; i < 15; i++){
            listaImageView.get(i).setTipoBotao(tipoBotoes[pos]);
            listaImageView.get(i).setNivelBotao(NIVEL_BT3);
            pos++;
        }

        pos =0;
        Collections.shuffle(Arrays.asList(tipoBotoes));
        for(int i=15; i < 20; i++){
            listaImageView.get(i).setTipoBotao(tipoBotoes[pos]);
            listaImageView.get(i).setNivelBotao(NIVEL_BT2);
            pos++;
        }

        pos =0;
        Collections.shuffle(Arrays.asList(tipoBotoes));
        for(int i=20; i < 25; i++){
            listaImageView.get(i).setTipoBotao(tipoBotoes[pos]);
            listaImageView.get(i).setNivelBotao(NIVEL_BT1);
            listaImageView.get(i).setEnabled(true);
            pos++;
        }


    }

    private void getBotaoClick(int id) {

        ImageViewJogo imagem= null;
        for (ImageViewJogo imgJogo : listaImageView){
            if(imgJogo.getId() == id){
               imagem = imgJogo;
                break;
            }
        }

        if(imagem == null){
            Log.e("Erro", "Nao foi encontrado a imagem");
            return;
        }

        switch (imagem.getNivelBotao()){
            case NIVEL_BT1:
                 setImagemBotao( imagem );

                break;
            case NIVEL_BT2:

                setImagemBotao( imagem );

                break;
            case NIVEL_BT3:

                setImagemBotao( imagem );

                break;
            case NIVEL_BT4:

                setImagemBotao( imagem );

                break;
            case NIVEL_BT5:

                setImagemBotao( imagem );

                break;
            default:
        }

        txtVida.setText(""+CONT_VIDA);
        txtPontos.setText(""+PONTOS);
        testaVida(CONT_VIDA);



    }

    private void testaVida(int contVida) {

        if(contVida == PERDEU){
            mensagem("Você Perdeu!");
            CONT_VIDA = 1;
            PONTOS =0;
            listaImageView.clear();
            preencherListaImageView();
            setImagemGridView();

        }
    }

    private void mensagem(String msg) {

        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }

    private void  habilitarNivel(int nivel){

        for(int i=0; i<listaImageView.size(); i++){

            if(listaImageView.get(i).getNivelBotao() == nivel) {
                listaImageView.get(i).setEnabled(true);
            }
        }

    }

    private void  desaHabilitarNivel(int nivel){

        for(int i=0; i<listaImageView.size(); i++){

            if(listaImageView.get(i).getNivelBotao() == nivel) {
                listaImageView.get(i).setEnabled(false);
            }
        }

    }

    private void setImagemBotao(ImageViewJogo imagem) {

        switch (imagem.getTipoBotao()){

            case PREMIO:
                Glide.with(this).load(idImgJogo[3]).asGif().into(imagem);
                habilitarNivel(imagem.getNivelBotao()+1);
                desaHabilitarNivel(imagem.getNivelBotao());
                break;

            case VIDA:

                CONT_VIDA++;
                PONTOS= PONTOS +10;
                Glide.with(this).load(idImgJogo[2]).asGif().into(imagem);
                habilitarNivel(imagem.getNivelBotao()+1);
                desaHabilitarNivel(imagem.getNivelBotao());

                break;
            case BOMBA:


                Glide.with(this).load(idImgJogo[1]).asGif().into(imagem);
                CONT_VIDA--;

                break;
            case SETA:

                PONTOS= PONTOS +10;
                Glide.with(this).load(idImgJogo[0]).asGif().into(imagem);
                habilitarNivel(imagem.getNivelBotao()+1);
                desaHabilitarNivel(imagem.getNivelBotao());
                break;


            default:

        }




    }

    @Override
    public void onClick(View v) {
        //mensagem("id: " + v.getId());
        getBotaoClick(v.getId());
    }
}
