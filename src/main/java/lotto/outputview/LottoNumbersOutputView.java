package lotto.outputview;

import lotto.Lotto;

import java.util.List;

public class LottoNumbersOutputView {

    public static void printPurchasedLottos(int numberOfLottos, List<Lotto> lottos) {
        System.out.println(numberOfLottos + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
