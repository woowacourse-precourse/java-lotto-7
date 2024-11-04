package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.UserWinningLottosInfo;
import lotto.global.LottoRank;

public class OutputView {

    public static final String RESULT_START_MESSAGE = "\n당첨 통계\n---";
    public static final String LOTTO_NUMBER_DELIMITER = ",";

    public static final String LOTTO_PRINT_FORMAT = "\n%d개를 구매했습니다.\n";
    public static final String LOTTO_DISPLAY_FORMAT = "[%s]\n";
    public static final String RESULT_DISPLAY_FORMAT = " - %s개\n";
    public static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.\n";

    public static void printLottos(Lottos lottos) {
        System.out.printf(LOTTO_PRINT_FORMAT, lottos.getLottos().size());
        lottos.getLottos()
                .forEach(OutputView::printLotto);
    }

    public static void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        String result = numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBER_DELIMITER + " "));

        System.out.printf(LOTTO_DISPLAY_FORMAT, result);
    }

    public static void printResult(UserWinningLottosInfo userWinningLottosInfo) {

        System.out.println(RESULT_START_MESSAGE);

        for (LottoRank rank : LottoRank.values()) {
            System.out.print(rank.toString());
            System.out.printf(RESULT_DISPLAY_FORMAT, userWinningLottosInfo.getWinningCountByLottoRank(rank));
        }

        System.out.printf(PROFIT_RATE_FORMAT, userWinningLottosInfo.getProfitRate());
    }

    public static void printErrorMessage(RuntimeException e) {
        System.out.println(e.getMessage());
    }
}
