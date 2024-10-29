package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final Integer price;
    private final Integer count;
    private final List<Lotto> lottos;

    public LottoMachine(Integer price){
        this.price = price;
        this.count = countLotto(price);
        this.lottos = new ArrayList<>();
    }

    private Integer countLotto(int price){
        return price / 1000;
    }


}
