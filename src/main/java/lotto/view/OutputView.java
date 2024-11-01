package lotto.view;

import lotto.enums.OutputMessage;

public class OutputView {
    public void printLottoCount(int lottoCount) {
        System.out.println(OutputMessage.LOTTO_COUNT.getMessage(lottoCount));
    }

    public void printWinningStatistics() {
        System.out.println(OutputMessage.WINNING_STATISTICS);
    }

    public void printSection() {
        System.out.println(OutputMessage.SECTION);
    }

    public void printThreeMatches(int count) {
        System.out.println(OutputMessage.THREE_MATCHES.getMessage(count));
    }

    public void printFourMatches(int count) {
        System.out.println(OutputMessage.FOUR_MATCHES.getMessage(count));
    }

    public void printFiveMatches(int count) {
        System.out.println(OutputMessage.FIVE_MATCHES.getMessage(count));
    }

    public void printFiveBonusMatches(int count) {
        System.out.println(OutputMessage.FIVE_BONUS_MATCHES.getMessage(count));
    }

    public void printSixMatches(int count) {
        System.out.println(OutputMessage.SIX_MATCHES.getMessage(count));
    }
}
