package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;

public class LottoGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;
    private static final int unitPrice = 1000;
    private int numberOfLottos;
    private PurchasedLottos purchasedLottos;

    public LottoGenerator() {
        this.purchasedLottos = new PurchasedLottos();
    }

    public PurchasedLottos generateLottos(int purchaseAmount) {
        calculateNumberOfLottos(purchaseAmount);
        while (purchasedLottos.getSize() < numberOfLottos) {
            purchasedLottos.addLotto(generateRandomLotto());
        }
        return purchasedLottos;
    }

    private void calculateNumberOfLottos(int purchaseAmount) {
        numberOfLottos = purchaseAmount / unitPrice;
    }

    private Lotto generateRandomLotto() {
        // TODO 로또 번호 출력 전 오름 차순 정렬
        List<Integer> oneLotto = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBERS_COUNT);
        return new Lotto(oneLotto);
    }
}
