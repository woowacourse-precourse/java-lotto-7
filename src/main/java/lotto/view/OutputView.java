package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String RESULT_HEADER = "당첨 통계";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.lf%%입니다.";
    private static final String DIVIDER = "---";
    private static final String PURCHASED_MESSAGE = "%d개를 구입했습니다.";

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(String.format(PURCHASED_MESSAGE, lottos.size()));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

}
