package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.LottoTickets;
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
        System.out.println("3개 일치 (5,000원) - " + winningStatistics.getRankCount(5) + "개");
        System.out.println("4개 일치 (50,000원) - " + winningStatistics.getRankCount(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningStatistics.getRankCount(3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningStatistics.getRankCount(2) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningStatistics.getRankCount(1) + "개");
    }

    public void showRateOfReturn(Long total, int purchaseAmount) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", (total / (double)purchaseAmount) * 100));
    }
}
