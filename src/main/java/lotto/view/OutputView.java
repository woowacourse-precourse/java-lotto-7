package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Ranking;

import java.util.List;
import java.util.Map;

import static lotto.util.Constants.*;

public class OutputView {
    public void printStartMessage() {
        System.out.println(LOTTO_START.getMessage());
    }

    public void printCountMessage(int amount) {
        System.out.println(LINE_BREAK.getMessage() + amount + LOTTO_COUNT.getMessage());
    }

    public void printLottoNumbers(List<Lotto> lottoes) {
        for (Lotto lotto : lottoes) {
            System.out.print(LEFT_BRACKET.getMessage());

            int size = lotto.numbers().size();

            for (int i = 0; i < size; i++) {
                System.out.print(lotto.numbers().get(i));

                if (i < size - 1) {
                    System.out.print(COMMA.getMessage());
                }
            }

            System.out.print(RIGHT_BRACKET.getMessage() + LINE_BREAK.getMessage());
        }
    }

    public void printWinningNumbers() {
        System.out.println(LINE_BREAK.getMessage() + LOTTO_NUMBERS.getMessage());
    }

    public void printBonusNumber() {
        System.out.println(LINE_BREAK.getMessage() + LOTTO_BONUS.getMessage());
    }

    public void printWinningStatistics() {
        System.out.println(LINE_BREAK.getMessage() + LOTTO_RESULT.getMessage());
        System.out.println(LINES.getMessage());
    }

    public void printWinningResult(Map<Ranking, Integer> result) {
        System.out.println(WINNING_THREE_COUNT.getMessage() + result.getOrDefault(Ranking.FIFTH, 0) + "개");
        System.out.println(WINNING_FOUR_COUNT.getMessage() + result.getOrDefault(Ranking.FOURTH, 0) + "개");
        System.out.println(WINNING_FIVE_COUNT.getMessage() + result.getOrDefault(Ranking.THIRD, 0) + "개");
        System.out.println(WINNING_FIVE_COUNT_BONUS.getMessage() + result.getOrDefault(Ranking.SECOND, 0) + "개");
        System.out.println(WINNING_SIX_COUNT.getMessage() + result.getOrDefault(Ranking.FIRST, 0) + "개");
    }

    public void printEarningRate(double earningRate) {
        System.out.print(FINAL_EARNING.getMessage() + String.format("%.1f", earningRate) + FINAL_RESULT.getMessage());
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}