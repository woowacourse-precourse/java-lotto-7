package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.domain.WinningStatistics;

public class OutputView {
    private static final String PURCHASE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBERS_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public void showPurchaseAmountInputMessage() {
        System.out.println(PURCHASE_INPUT_MESSAGE);
    }


    public void showLottoCountAndNumbers(LottoTickets lotteries) {
        showLottoCount(lotteries.getCount());
        showLottoNumbers(lotteries.getLottoNumbers());
    }

    private void showLottoCount(int count) {
        System.out.println(count + PURCHASE_COUNT_MESSAGE);
    }

    private void showLottoNumbers(List<String> lottoNumbers) {
        lottoNumbers.forEach(System.out::println);
    }

    public void showWinningNumbersInputMessage() {
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
    }

    public void showBonusNumberInputMessage() {
        System.out.println(BONUS_NUMBERS_INPUT_MESSAGE);
    }

    public void showResult(WinningStatistics winningStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(Rank.FIFTH.getDescription() + " - " + winningStatistics.getRankCount(Rank.FIFTH) + "개");
        System.out.println(Rank.FOURTH.getDescription() + " - " + winningStatistics.getRankCount(Rank.FOURTH) + "개");
        System.out.println(Rank.THIRD.getDescription() + " - " + winningStatistics.getRankCount(Rank.THIRD) + "개");
        System.out.println(Rank.SECOND.getDescription() + " - " + winningStatistics.getRankCount(Rank.SECOND) + "개");
        System.out.println(Rank.FIRST.getDescription() + " - " + winningStatistics.getRankCount(Rank.FIRST) + "개");
    }

    public void showRateOfReturn(double rateOfReturn) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", rateOfReturn));
    }
}
