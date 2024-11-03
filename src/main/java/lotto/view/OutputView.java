package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {

    public static final String LOTTO_PRINT_MESSAGE = "개를 구매했습니다.";
    public static final String RESULT_START_MESSAGE = "당첨 통계";
    public static final String PROFIT_RATE_PREFIX = "총 수익률은 ";
    public static final String PROFIT_RATE_SUFFIX = "%입니다.";

    public static final String LOTTO_NUMBER_DELIMITER = ",";
    public static final String LOTTO_DISPLAY_FORMAT = "[%s]\n";

    public static void printLottos(Lottos lottos) {
        List<Lotto> purchasedLottos = lottos.getLottos();

        for (Lotto lotto : purchasedLottos) {

        }
    }

}
