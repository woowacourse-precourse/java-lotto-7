package lotto.view;

import java.util.List;

public class OutputView {

    public void outputLotteryMachine(List<String> lotteryMachineResult,int number) {
        System.out.printf("%d개를 구매했습니다.", number);
        lotteryMachineResult.forEach(System.out::println);
    }

    public void outputWinningResult(String winningResult) {
        System.out.println("당첨 통계\n" + "---");
        System.out.println(winningResult);
    }

    public void newLine() {
        System.out.println();
    }
}
