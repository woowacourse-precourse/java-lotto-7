package lotto.view;

import static lotto.domain.LottosResult.*;
import static lotto.domain.Rank.*;
import static lotto.message.ViewMessage.*;

import java.sql.SQLOutput;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.LottosResult;

public class OutputView {
    public static final String LOTTO_NUMBER_JOINNING_MARK = ", ";
    public static final String PRINT_LOTTO_NUMBER_FORMAT_PREFIX = "[";
    public static final String PRINT_LOTTO_NUMBER_FORMAT_SUFFIX = "]";

    public static void printLottosResult(LottosResult lottoResult) {
        System.out.println();
        System.out.println(OUTPUT_RESULT_TITLE.getMessage());
        System.out.println(FIFTH.format(lottoResult.get(FIFTH.getName())));
        System.out.println(FOURTH.format(lottoResult.get(FOURTH.getName())));
        System.out.println(THIRD.format(lottoResult.get(THIRD.getName())));
        System.out.println(SECOND.format(lottoResult.get(SECOND.getName())));
        System.out.println(FIRST.format(lottoResult.get(FIRST.getName())));
    }

    public static void printLottosReturns(double returnsByLottos) {
        System.out.printf(OUTPUT_LOTTOS_RETURNS.getMessage(), returnsByLottos);
    }
    public static void printLottosInfo(Lottos lottos) {
        System.out.println();
        System.out.println(OUTPUT_LOTTOS_COUNT.format(lottos.getLotto().size()));

        for (Lotto lotto : lottos.getLotto()){
            System.out.println(
                    PRINT_LOTTO_NUMBER_FORMAT_PREFIX+
                    lotto.getNumbers().stream()
                    .sorted()
                    .map(String::valueOf)
                    .collect(Collectors.joining(LOTTO_NUMBER_JOINNING_MARK))
                    +PRINT_LOTTO_NUMBER_FORMAT_SUFFIX);
        }
        System.out.println();
    }
}
