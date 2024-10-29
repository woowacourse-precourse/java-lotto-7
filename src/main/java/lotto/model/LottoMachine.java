package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final Integer price;
    private final Integer count;
    private final List<Lotto> lottos;

    public LottoMachine(Integer price){
        validateLottoPrice(price);
        this.price = price;
        this.count = countLotto(price);
        this.lottos = new ArrayList<>();
    }

    private void validateLottoPrice(Integer price){
        if (price % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해 주세요.");
    }

    private Integer countLotto(int price){
        return price / 1000;
    }


}
