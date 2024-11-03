package lotto.view;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;

import java.util.List;
import lotto.domain.LottoTickets;
import lotto.domain.WinningStatistics;
import lotto.message.OutputMessage;

public class OutputView {

    public void showPurchaseAmountInputMessage() {
        System.out.println(OutputMessage.PURCHASE_INPUT_MESSAGE.getMessage());
    }


    public void showLottoCountAndNumbers(LottoTickets lotteries) {
        showLottoCount(lotteries.getCount());
        showLottoNumbers(lotteries.getLottoNumbers());
    }

    private void showLottoCount(int count) {
        System.out.println(count + OutputMessage.PURCHASE_COUNT_MESSAGE.getMessage());
    }

    private void showLottoNumbers(List<String> lottoNumbers) {
        lottoNumbers.forEach(System.out::println);
    }

    public void showWinningNumbersInputMessage() {
        System.out.println(OutputMessage.WINNING_NUMBERS_INPUT_MESSAGE.getMessage());
    }

    public void showBonusNumberInputMessage() {
        System.out.println(OutputMessage.BONUS_NUMBERS_INPUT_MESSAGE.getMessage());
    }

    public void showWinningStatistics(WinningStatistics winningStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(FIFTH.getDescription() + " - " + winningStatistics.getRankCount(FIFTH) + "개");
        System.out.println(FOURTH.getDescription() + " - " + winningStatistics.getRankCount(FOURTH) + "개");
        System.out.println(THIRD.getDescription() + " - " + winningStatistics.getRankCount(THIRD) + "개");
        System.out.println(SECOND.getDescription() + " - " + winningStatistics.getRankCount(SECOND) + "개");
        System.out.println(FIRST.getDescription() + " - " + winningStatistics.getRankCount(FIRST) + "개");
    }

    public void showRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rateOfReturn);
    }
}
