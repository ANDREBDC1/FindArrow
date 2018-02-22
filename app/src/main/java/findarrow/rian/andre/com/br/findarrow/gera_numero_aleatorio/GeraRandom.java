package findarrow.rian.andre.com.br.findarrow.gera_numero_aleatorio;

/**
 * Created by user on 22/02/2018.
 */

public class GeraRandom {

    public static int geraNumeroEntre(int numeroIncio, int numeroFinal){
        return  (int) Math.ceil((Math.random() * (numeroFinal - numeroIncio +1)) -1 + numeroIncio );
    }
}
