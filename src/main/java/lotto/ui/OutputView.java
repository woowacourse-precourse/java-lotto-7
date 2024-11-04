package lotto.ui;

import java.util.List;
import lotto.ui.dto.LottoNumbersResponse;
import lotto.ui.dto.LottoStatisticsResponse;
import lotto.ui.dto.PurchasedLottoResponse;
import lotto.ui.dto.WinningCountByPrize;

public class OutputView {

    private static final String WINNING_COUNT_BY_PRIZE_MESSAGE_FORMAT = "%d개 일치%s (%,d원) - %d개%n";
    private static final String PURCHASE_COUNT_MESSAGE_FORMAT = "%n%d개를 구매했습니다.%n";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.%n";
    private static final String MATCH_BONUS_MESSAGE = ", 보너스 볼 일치";
    private static final String WINNING_STATISTICS_MESSAGE = "\n당첨통계";
    private static final String DIVIDER = "---";
    private static final String EMPTY = "";
    private static final int SECOND = 2;

    public void displayPurchasedLotto(PurchasedLottoResponse response) {
        List<LottoNumbersResponse> lottoNumbers = response.getLottos();
        System.out.printf(PURCHASE_COUNT_MESSAGE_FORMAT, lottoNumbers.size());
        lottoNumbers.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void displayWinningStatistics(LottoStatisticsResponse response) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(DIVIDER);

        List<WinningCountByPrize> winningCountByPrizes = response.winningCountByPrizes();
        winningCountByPrizes.forEach(this::displayWinningCountByPrizeMessage);

        System.out.printf(PROFIT_RATE_MESSAGE, response.profitRate());
    }

    private void displayWinningCountByPrizeMessage(WinningCountByPrize winningCountByPrize) {
        System.out.printf(WINNING_COUNT_BY_PRIZE_MESSAGE_FORMAT,
                winningCountByPrize.getMatchCount(),
                determineBonusMessage(winningCountByPrize),
                winningCountByPrize.getPrizeMoney(),
                winningCountByPrize.getWinningCount()
        );
    }

    private static String determineBonusMessage(WinningCountByPrize winningCountByPrize) {
        if (winningCountByPrize.getRank() == SECOND) {
            return MATCH_BONUS_MESSAGE;
        }
        return EMPTY;
    }

    public void displayException(String message) {
        System.out.println(message);
    }

}
