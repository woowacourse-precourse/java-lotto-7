package lotto.view;

import java.util.List;
import lotto.domain.LottoResult;
import lotto.enums.OutputMessage;

public class OutputView {
    public void printEnter() {
        System.out.println(OutputMessage.ENTER.getMessage());
    }

    public void printLottoCount(int lottoCount) {
        System.out.println(OutputMessage.LOTTO_COUNT.getMessage(lottoCount));
    }

    public void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.print(OutputMessage.START_SQUARE_BRACKET.getMessage());
        for (int i = 0; i < lottoNumbers.size(); i++) {
            System.out.print(lottoNumbers.get(i));
            if (i != lottoNumbers.size() - 1) {
                System.out.print(OutputMessage.COMMA.getMessage() + OutputMessage.SPACE.getMessage());
            }
        }
        System.out.print(OutputMessage.FINISH_SQUARE_BRACKET.getMessage());
        System.out.println();
    }

    public void printWinningStatistics() {
        System.out.println(OutputMessage.WINNING_STATISTICS.getMessage());
    }

    public void printSection() {
        System.out.println(OutputMessage.SECTION.getMessage());
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

    public void printResult(int purchaseAmount, LottoResult lottoResult) {
        double winningRate = (double) lottoResult.getPrize() / purchaseAmount * 100;
        System.out.println(OutputMessage.WINNING_RESULT.getMessage(winningRate));
    }
}
