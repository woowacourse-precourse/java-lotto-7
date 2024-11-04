package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoGame {
    private static final int PRICE_PER_LOTTO = 1000;
    private final List<Lotto> purchasedLottos = new ArrayList<>();
    private final int purchaseAmount;


    public LottoGame(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        generateLottos();
    }

    private void generateLottos() {
        int numberOfLottos = purchaseAmount / PRICE_PER_LOTTO;
        for (int i = 0; i < numberOfLottos; i++) {
            purchasedLottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    public void printPurchasedLottos() {
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : purchasedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }


}
