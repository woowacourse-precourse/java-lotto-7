package lotto.view;

import static lotto.global.Message.BUY_LOTTO_COUNT_MESSAGE;

public class OutputView {

    public void printTotalLottoCounts(int lottoCounts) {
        System.out.println("\n" + lottoCounts + BUY_LOTTO_COUNT_MESSAGE.getMsg());
    }
}
