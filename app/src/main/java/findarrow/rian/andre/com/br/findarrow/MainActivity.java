package findarrow.rian.andre.com.br.findarrow;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.HashMap;
import java.util.Map;

import findarrow.rian.andre.com.br.findarrow.adaptador.Adaptador;
import findarrow.rian.andre.com.br.findarrow.gera_numero_aleatorio.GeraRandom;

public class MainActivity extends Activity {

    int []  img = new int[]{R.drawable.bombfuse,R.drawable.bombfuse,R.drawable.bombfuse,R.drawable.bombfuse,
            R.drawable.bombfuse,R.drawable.bombfuse,R.drawable.bombfuse,R.drawable.bombfuse,R.drawable.bombfuse,
            R.drawable.bombfuse,R.drawable.bombfuse,R.drawable.bombfuse,R.drawable.bombfuse,R.drawable.bombfuse,
            R.drawable.bombfuse,R.drawable.bombfuse,R.drawable.bombfuse,R.drawable.bombfuse,R.drawable.bombfuse,
            R.drawable.bombfuse,R.drawable.bombfuse,R.drawable.bombfuse,R.drawable.bombfuse,R.drawable.bombfuse,
            R.drawable.bombfuse,R.drawable.bombfuse,R.drawable.bombfuse,R.drawable.bombfuse,R.drawable.bombfuse,
            R.drawable.bombfuse};

    Map<Integer,String> valoresNivel1 = new HashMap<>();
    Map<Integer,String> valoresNivel2 = new HashMap<>();
    Map<Integer,String> valoresNivel3 = new HashMap<>();
    Map<Integer,String> valoresNivel4 = new HashMap<>();
    Map<Integer,String> valoresNivel5 = new HashMap<>();
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // definir nivel 1
        valoresNivel1.put(GeraRandom.geraNumeroEntre(0,4), "vida");
        valoresNivel1.put(GeraRandom.geraNumeroEntre(0,4), "seta");

        // definir nivel 2
        valoresNivel2.put(GeraRandom.geraNumeroEntre(5,9),"vida");
        valoresNivel2.put(GeraRandom.geraNumeroEntre(5,9), "seta");

        // definir nivel 3
        valoresNivel3.put(GeraRandom.geraNumeroEntre(10,14),"vida");
        valoresNivel3.put(GeraRandom.geraNumeroEntre(10,14), "seta");

        // definir nivel 4
        valoresNivel4.put(GeraRandom.geraNumeroEntre(15,19),"vida");
        valoresNivel4.put(GeraRandom.geraNumeroEntre(15,19), "seta");

        // definir nivel 5
        valoresNivel5.put(GeraRandom.geraNumeroEntre(20,24),"vida");
        valoresNivel5.put(GeraRandom.geraNumeroEntre(20,24), "seta");


        gridView = (GridView) findViewById(R.id.gridViewId);
        gridView.setAdapter(new Adaptador(this, img));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }




}
