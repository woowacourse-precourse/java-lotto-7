package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

public class OutputView {
    private static final String LOTTO_COUNT_MESSAGE = "\n%d개를 구매했습니다.\n";

    public static void printPurchasedLottos(Lottos lottos) {
        printLottoCount(lottos);
        printLottoNumbers(lottos);
    }

    private static void printLottoCount(Lottos lottos) {
        System.out.printf(LOTTO_COUNT_MESSAGE, lottos.lottoCount());
    }

    private static void printLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers().stream()
                    .map(LottoNumber::getNumber)
                    .sorted()
                    .toList());
        }
    }
}
