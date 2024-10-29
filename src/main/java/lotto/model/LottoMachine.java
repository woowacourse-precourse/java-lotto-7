package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final Integer price;
    private final List<Lotto> lottos;

    public LottoMachine(Integer price){
        this.price = price;
        this.lottos = new ArrayList<>();
    }


}
