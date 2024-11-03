package lotto.view;

import lotto.domain.WinningCondition;
import lotto.domain.WinningResult;

public class OutputView {
    public void printlnMessage(String message) {
        System.out.println(message);
    }

    public void printlnMessageWithEmptyLine(String message) {
        printlnMessage(message);
        printEmptyLine();
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public void printResult(WinningResult result, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (WinningCondition winningCondition : WinningCondition.getAllConditions().reversed()) {
            String format = determineFormat(winningCondition);
            String str = String.format(
                    format,
                    winningCondition.getWinningNumberCount(),
                    String.format("%,d", winningCondition.getRewardAmount()),
                    result.getResultMap().get(winningCondition).size()
            );
            System.out.println(str);
        }
        String str = String.format("총 수익률은 %s%%입니다.", profitRate);
        System.out.println(str);
    }

    private String determineFormat(WinningCondition winningCondition) {
        if (winningCondition.mustIncludeBonusNumber()) {
            return "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
        }
        return "%d개 일치 (%s원) - %d개";
    }
}
