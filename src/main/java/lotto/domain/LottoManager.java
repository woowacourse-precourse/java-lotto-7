package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public enum LottoManager {
    INSTANCE;

    private static final int LOTTO_PRICE = 1000;

    public Integer getPurchasableLottos(Long purchaseAmount) {
        return (int) (purchaseAmount / LOTTO_PRICE);
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
}
