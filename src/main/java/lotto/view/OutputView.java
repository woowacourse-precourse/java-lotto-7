package lotto.view;

import static lotto.view.ViewConstant.DIVIDER;
import static lotto.view.ViewConstant.HOW_MANY_DID_YOU_PURCHASED;
import static lotto.view.ViewConstant.LOTTERY_RESULT;

import java.util.List;

public class OutputView {

    public void outputLotteryMachine(List<String> lotteryMachineResult,int number) {
        System.out.printf(HOW_MANY_DID_YOU_PURCHASED.getMessage(), number);
        lotteryMachineResult.forEach(System.out::println);
    }

    public void outputWinningResult(String winningResult) {
        System.out.println(LOTTERY_RESULT.getMessage() + DIVIDER.getMessage());
        System.out.println(winningResult);
    }

    public void newLine() {
        System.out.println();
    }
}
