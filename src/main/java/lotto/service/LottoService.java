package lotto.service;

import lotto.factory.LottoFactory;
import lotto.model.Lotto;

import java.util.List;

public class LottoService {
    public List<Lotto> purchase(int amount){
        // 구매할 수 있는 로또 개수
        int count = amount / LottoFactory.PRICE;

        return LottoFactory.create(count);
    }
}
