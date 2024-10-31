package lotto.view;

import java.util.List;
import lotto.Lotto;

public class LottoOutputView {

    private LottoOutputView() {
    }

    public static void printPurchaseLotto(List<Lotto> lottos) {
        System.out.format("%d개를 구매했습니다.\n", lottos.size());
        lottos.forEach(System.out::println);
    }
}
