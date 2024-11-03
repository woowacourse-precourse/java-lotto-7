package lotto.io;

import lotto.domain.Lottos;
import lotto.domain.WinnerFrequency;
import lotto.domain.WinningStatistic;

public class OutputHandler {

    public void showPriceInputNavigateMessage() {
        System.out.println(IOMessageTemplate.PRICE_NAVIGATE.format());
    }

    public void showPurchasedLottos(Lottos lottos) {
        showNewLine();
        showLottoCountMessage(lottos);
        showEachLottoNumbers(lottos);
        showNewLine();
    }

    public void showWinningNumbersNavigateMessage() {
        System.out.println(IOMessageTemplate.WINNING_NUMBERS_NAVIGATE.format());
    }

    public void showBonusNumberNavigateMessage() {
        showNewLine();
        System.out.println(IOMessageTemplate.BONUS_NUMBER_NAVIGATE.format());
    }

    public void showWinningStatistic(WinningStatistic statistic) {
        showNewLine();
        showWinningStatisticBanner();
        showEachWinner(statistic);
        showProfitRate(statistic);
    }

    private void showLottoCountMessage(Lottos lottos) {
        System.out.println(IOMessageTemplate.PURCHASED.format(lottos.size()));
    }

    private void showEachLottoNumbers(Lottos lottos) {
        lottos.toUnmodifiableList().forEach(System.out::println);
    }

    private void showWinningStatisticBanner() {
        System.out.println(IOMessageTemplate.WINNING_STATISTIC_BANNER.format());
        System.out.println(IOMessageTemplate.WINNING_STATISTIC_HORIZONTAL_RULE.format());
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