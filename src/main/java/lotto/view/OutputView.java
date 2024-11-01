package lotto.view;

import lotto.domain.Consumer;
import lotto.domain.Lotto;

public class OutputView {

    public static void ErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printLottoCount(int number) {
        System.out.println("\n" + number + "개를 구매했습니다.");
    }

    public static void printLottoes(Consumer lottoes) {
        for (Lotto lotto : lottoes.getLottoes()) {
            System.out.println(lotto.getNumbers());
        }
    }

}
