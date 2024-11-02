package lotto;

import java.util.List;

public class LottoOutputView {
    public static void printPurchasedLottoCount(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
