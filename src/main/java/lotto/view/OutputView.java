package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

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
}