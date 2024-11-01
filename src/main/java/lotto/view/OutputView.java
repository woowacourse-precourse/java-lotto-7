package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public abstract class OutputView {

    public static void printPurchasedLottos(int lottoCount, List<Lotto> purchasedLottos) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        purchasedLottos.forEach(lotto -> {
            System.out.println(lotto.toString());
        });
    }

}
