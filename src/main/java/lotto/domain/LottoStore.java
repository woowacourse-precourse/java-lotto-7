package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public enum LottoStore {
    INSTANCE;

    private static final int LOTTO_PRICE = 1000;

    public Integer getMaxPurchasableLottos(int purchaseAmount){
        return purchaseAmount / LOTTO_PRICE;
    }

    public List<Lotto> purchase(int count){
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < count; i++){
            List<Integer> numbers = Lotto.createNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        return lottos;
    }

    public Integer getPrice(){
        return LOTTO_PRICE;
    }
}
