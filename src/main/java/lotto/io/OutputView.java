package lotto.io;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    public static void printPurchaseLottos(List<Lotto> lottos) {
        printLottoCount(lottos.size());
        printLottos(lottos);
    }
    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
