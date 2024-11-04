package lotto.view;

import static lotto.enums.Message.ERROR_PREFIX;
import static lotto.enums.Message.LOTTO_COUNT;
import static lotto.enums.Message.MATCH_RESULT;
import static lotto.enums.Message.MATCH_WITH_BONUS_RESULT;
import static lotto.enums.Message.PROFIT_RATE;
import static lotto.enums.Message.WINNING_STATISTICS_HEADER;

import java.util.List;

public class OutputView {

    public void printLottoCount(int lottoCount) {
        System.out.printf((LOTTO_COUNT.getMessage()), lottoCount);
    }

    public void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public void printWinningStatisticsHeader() {
        System.out.println(WINNING_STATISTICS_HEADER.getMessage());
    }

    public void printMatchResult(int matchCount, int winningAmount, int winningCount) {
        System.out.printf(MATCH_RESULT.getMessage(), matchCount, winningAmount, winningCount);
    }

    public void printMatchWithBonusResult(int matchCount, int winningAmount, int winningCount) {
        System.out.printf(MATCH_WITH_BONUS_RESULT.getMessage(), matchCount, winningAmount, winningCount);
    }

    public void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE.getMessage(), profitRate);
    }

    public void printExceptionMessage(String exceptionMessage) {
        System.out.println(ERROR_PREFIX.getMessage() + exceptionMessage);
    }
}
