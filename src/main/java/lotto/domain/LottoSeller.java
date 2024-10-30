package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.utils.RandomNumbersGenerator;

public class LottoSeller {
    LottoMachine lottoMachine = new LottoMachine(new RandomNumbersGenerator());

    List<Lotto> sell(int price) {
        validatePrice(price);

        List<Lotto> lottos = new ArrayList<>();
        int sellCount = getSellCount(price);
        for (int i = 0; i < sellCount; i++) {
            lottos.add(lottoMachine.generate());
        }
        return lottos;
    }

    private void validatePrice(int price) {
        if (price == 0 || price % LottoCommittee.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("올바르지않은 구입금액");
        }
    }

    private int getSellCount(int price) {
        return price / LottoCommittee.LOTTO_PRICE;
    }
}
