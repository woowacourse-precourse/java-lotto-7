package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

import static lotto.util.Constants.LOTTO_COUNT;
import static lotto.util.Constants.LOTTO_START;

public class OutputView {

    private static final String LINE_BREAK = "\n";

    public void printStartMessage() {
        System.out.println(LOTTO_START.getMessage());
    }

    public void printCountMessage(int amount) {
        System.out.println(LINE_BREAK + amount + LOTTO_COUNT.getMessage());
    }

    public void printLottoNumbers(List<Lotto> lottoes) {
        for (Lotto lotto : lottoes) {
            System.out.print("[");

            int size = lotto.numbers().size();

            for (int i = 0; i < size; i++) {
                System.out.print(lotto.numbers().get(i));

                if (i < size - 1) {
                    System.out.print(", ");
                }
            }

            System.out.print("]\n");
        }
    }
}