package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.service.RandomNumbersDraw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoDraw {
    private final int LOTTO_PRICE = 1000;

    private final int numberOfPurchases;
    private final List<Lotto> lottoDrawNumbers;

    public LottoDraw(int purchaseAmount) {
        numberOfPurchases = purchaseAmount / LOTTO_PRICE;
        RandomNumbersDraw randomNumbersDraw = new RandomNumbersDraw();
        lottoDrawNumbers = randomNumbersDraw.randomLottoNumberDraw(numberOfPurchases);
    }

    public int getNumberOfPurchases() {
        return numberOfPurchases;
    }

    public List<Lotto> getLottoDrawNumbers() {
        return lottoDrawNumbers;
    }
}
