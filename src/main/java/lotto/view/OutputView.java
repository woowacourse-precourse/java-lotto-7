package lotto.view;

import lotto.domain.WinningCondition;
import lotto.domain.WinningResult;
import lotto.view.console.ConsoleWriter;

public class OutputView {
    public void printResult(WinningResult result, double profitRate) {
        ConsoleWriter.printlnMessage("당첨 통계");
        ConsoleWriter.printlnMessage("---");
        for (WinningCondition winningCondition : WinningCondition.getAllConditions().reversed()) {
            String format = determineFormat(winningCondition);
            String str = String.format(
                    format,
                    winningCondition.getWinningNumberCount(),
                    String.format("%,d", winningCondition.getRewardAmount()),
                    result.getResultMap().get(winningCondition).size()
            );
            ConsoleWriter.printlnMessage(str);
        }
        String str = String.format("총 수익률은 %s%%입니다.", profitRate);
        ConsoleWriter.printlnMessage(str);
    }

    private String determineFormat(WinningCondition winningCondition) {
        if (winningCondition.mustIncludeBonusNumber()) {
            return "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
        }
        return "%d개 일치 (%s원) - %d개";
    }
}
