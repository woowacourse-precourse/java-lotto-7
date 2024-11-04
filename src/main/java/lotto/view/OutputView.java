package lotto.view;

import static lotto.enums.ViewConstants.PRINT_3LINES;
import static lotto.enums.ViewConstants.PRINT_LOTTO_COUNT;
import static lotto.enums.ViewConstants.PRINT_MATCH_NUMBERS;
import static lotto.enums.ViewConstants.PRINT_MATCH_NUMBERS_SECOND;
import static lotto.enums.ViewConstants.PRINT_PERCENT;
import static lotto.enums.ViewConstants.PRINT_PRIZE;
import static lotto.enums.ViewConstants.PRINT_RESULT_STATISTICS;
import static lotto.enums.ViewConstants.PRINT_RESULT_STATISTICS_TITLE;
import static lotto.enums.ViewConstants.PRINT_WINNING_LOTTO_COUNT;

import java.util.List;
import lotto.enums.LottoPrizes;
import lotto.model.Lotto;

public class OutputView {

    public void printLottoCount(int price) {
        System.out.println();
        System.out.println(price / 1000 + PRINT_LOTTO_COUNT);

    }

    public void printUserLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printResultStatistics(double rateOfReturn) {
        System.out.println(PRINT_RESULT_STATISTICS_TITLE);
        System.out.println(PRINT_3LINES);
        for (LottoPrizes prize : LottoPrizes.values()) {
            if (prize == LottoPrizes.SECOND) {
                System.out.println(
                        prize.getMatchNumberCount() + PRINT_MATCH_NUMBERS_SECOND + prize.getPrizeMoney() + PRINT_PRIZE
                                + prize.getCount() + PRINT_WINNING_LOTTO_COUNT);
            }
            System.out.println(prize.getMatchNumberCount() + PRINT_MATCH_NUMBERS + prize.getPrizeMoney() + PRINT_PRIZE
                    + prize.getCount() + PRINT_WINNING_LOTTO_COUNT);
        }

        System.out.println(PRINT_RESULT_STATISTICS + rateOfReturn + PRINT_PERCENT);
    }
}
