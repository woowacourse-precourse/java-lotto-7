package lotto.io;

import lotto.domain.Lottos;
import lotto.domain.WinnerFrequency;
import lotto.domain.WinningStatistic;

public class OutputHandler {

    private static final String PRICE_INPUT_NAVIGATE = "구입금액을 입력해 주세요.";
    private static final String PURCHASED_MESSAGE_TEMPLATE = "%d개를 구매했습니다.";
    private static final String WINNING_NUMBERS_INPUT_NAVIGATE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_NAVIGATE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTIC_BANNER = "당첨 통계";
    private static final String WINNING_STATISTIC_DELIMITER = "---";

    public void showPriceInputNavigateMessage() {
        System.out.println(PRICE_INPUT_NAVIGATE);
    }

    public void showPurchasedLottos(Lottos lottos) {
        showNewLine();
        showLottoCountMessage(lottos);
        showEachLottoNumbers(lottos);
        showNewLine();
    }

    public void showWinningNumbersNavigateMessage() {
        System.out.println(WINNING_NUMBERS_INPUT_NAVIGATE);
    }

    public void showBonusNumberNavigateMessage() {
        showNewLine();
        System.out.println(BONUS_NUMBER_INPUT_NAVIGATE);
    }

    public void showWinningStatistic(WinningStatistic statistic) {
        showNewLine();
        showWinningStatisticBanner();
        showEachWinner(statistic);
        showProfitRate(statistic);
    }

    private void showLottoCountMessage(Lottos lottos) {
        System.out.println(String.format(PURCHASED_MESSAGE_TEMPLATE, lottos.size()));
    }

    private void showEachLottoNumbers(Lottos lottos) {
        lottos.toUnmodifiableList().forEach(System.out::println);
    }

    private void showWinningStatisticBanner() {
        System.out.println(WINNING_STATISTIC_BANNER);
        System.out.println(WINNING_STATISTIC_DELIMITER);
    }

    private void showEachWinner(WinningStatistic statistic) {
        for (WinnerFrequency winnerFrequency : statistic.getWinnerFrequency()) {
            String winnerTemplate = winnerFrequency.getMessage();
            System.out.println(winnerTemplate);
        }
    }

    private void showProfitRate(WinningStatistic statistic) {
        System.out.println(statistic.getFormattedProfitRate());
    }

    private void showNewLine() {
        System.out.println();
    }
}