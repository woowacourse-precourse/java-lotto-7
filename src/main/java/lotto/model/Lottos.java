package lotto.model;

import lotto.utils.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private static Lottos lottos;

    private Lottos(){};

    public static Lottos getLottos(){
        if(lottos == null){
            lottos = new Lottos();
        }
        return lottos;
    }

    private List<Lotto> buyLottos;

}
