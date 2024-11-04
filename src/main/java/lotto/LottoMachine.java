package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottos = new ArrayList<Lotto>();

    public LottoMachine(int money) {
        purchaseLottos(money);
    }

    private void purchaseLottos(int money) {
        int numberOfLottos = money / LOTTO_PRICE;
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(Lotto.generateRandomLotto());
        }
        System.out.println(numberOfLottos + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
        System.out.println();
    }
}
