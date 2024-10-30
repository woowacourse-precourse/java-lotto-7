package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;
    private int lottoCount;
    private List<Lotto> lottos;

    public void generateLottos(int purchaseAmount) {
        getLottoCount(purchaseAmount);

        for (int i = 0; i < this.lottoCount; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            this.lottos.add(new Lotto(randomNumbers));
        }
    }

    private void getLottoCount(int purchaseAmount) {
        this.lottoCount = purchaseAmount % LOTTO_PRICE;
    }
}
