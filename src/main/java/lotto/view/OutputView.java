package lotto.view;

import static lotto.message.ViewMessage.*;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {
    public static final String LOTTO_NUMBER_JOINNING_MARK = ", ";
    public static final String PRINT_LOTTO_NUMBER_FORMAT_PREFIX = "[";
    public static final String PRINT_LOTTO_NUMBER_FORMAT_SUFFIX = "]";

    public static void printLottosResult(Map<String, Integer> lottoResult) {
        System.out.println(OUTPUT_RESULT_TITLE.getMessage());
        System.out.println(MATCH_3_COUNT.format(lottoResult.get("5등")));
        System.out.println(MATCH_4_COUNT.format(lottoResult.get("4등")));
        System.out.println(MATCH_5_COUNT.format(lottoResult.get("3등")));
        System.out.println(MATCH_5_AND_BONUS_COUNT.format(lottoResult.get("2등")));
        System.out.println(MATCH_6_COUNT.format(lottoResult.get("1등")));
    }

    public static void printLottosReturns(double returnsByLottos) {
        System.out.printf(OUTPUT_LOTTOS_RETURNS.getMessage(),returnsByLottos);
    }
    public static void printBoughtInfo(Lottos lottos) {
        System.out.println(OUTPUT_LOTTOS_COUNT.format(lottos.getLotto().size()));

        for (Lotto lotto : lottos.getLotto())
            System.out.println(
                    PRINT_LOTTO_NUMBER_FORMAT_PREFIX+
                    lotto.getNumbers().stream()
                    .sorted()
                    .map(String::valueOf)
                    .collect(Collectors.joining(LOTTO_NUMBER_JOINNING_MARK))
                    +PRINT_LOTTO_NUMBER_FORMAT_SUFFIX);
    }
}
