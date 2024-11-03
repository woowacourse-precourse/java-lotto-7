package lotto.service;

import static lotto.common.config.Constants.LOTTO_NUMBERS_COUNT;
import static lotto.common.config.Constants.MAX_NUMBER;
import static lotto.common.config.Constants.MIN_NUMBER;
import static lotto.common.config.Constants.UNIT_PRICE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;

public class LottoGenerator {
    private int numberOfLottos;
    private PurchasedLottos purchasedLottos;

    public LottoGenerator() {
        this.purchasedLottos = new PurchasedLottos(); // TODO
    }

    public PurchasedLottos generateLottos(int purchaseAmount) {
        calculateNumberOfLottos(purchaseAmount);
        while (purchasedLottos.getSize() < numberOfLottos) {
            purchasedLottos.addLotto(generateRandomLotto());
        }
        return purchasedLottos;
    }

    private void calculateNumberOfLottos(int purchaseAmount) {
        numberOfLottos = purchaseAmount / UNIT_PRICE.getNumber();
    }

    private Lotto generateRandomLotto() {
        List<Integer> oneLotto = Randoms.pickUniqueNumbersInRange(MIN_NUMBER.getNumber(), MAX_NUMBER.getNumber(),
                LOTTO_NUMBERS_COUNT.getNumber());
        Collections.sort(oneLotto);
        return new Lotto(oneLotto);
    }
}
