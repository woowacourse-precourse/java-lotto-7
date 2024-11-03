package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningCondition;
import lotto.domain.WinningResult;

public class OutputView {
    public void printlnMessage(String message) {
        System.out.println(message);
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public void printlnMessageWithEmptyLine(String message) {
        printlnMessage(message);
        printEmptyLine();
    }

    public void printResult(WinningResult result, double profitRate) {
        printlnMessage("당첨 통계");
        printlnMessage("---");
        printWinningResult(result);
        printProfitRate(profitRate);
    }

    public void printlnCreateLottos(Lottos lottos) {
        int lottoCount = lottos.getLottos().size();
        printlnMessage(lottoCount + "개를 구매했습니다.");

        for (Lotto lotto : lottos.getLottos()) {
            String formattedNumbers = lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ", "[", "]"));
            printlnMessage(formattedNumbers);
        }
    }

    private void printWinningResult(WinningResult result) {
        List<WinningCondition> winningConditionPrintSequence = WinningCondition.getAllConditions().reversed();
        for (WinningCondition winningCondition : winningConditionPrintSequence) {
            String format = determinePrintFormat(winningCondition);
            String str = String.format(
                    format,
                    winningCondition.getWinningNumberCount(),
                    String.format("%,d", winningCondition.getRewardAmount()),
                    result.getResultMap().get(winningCondition).size()
            );
            printlnMessage(str);
        }
    }

    private String determinePrintFormat(WinningCondition winningCondition) {
        if (winningCondition.mustIncludeBonusNumber()) {
            return "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
        }
        return "%d개 일치 (%s원) - %d개";
    }

    private void printProfitRate(double profitRate) {
        String str = String.format("총 수익률은 %s%%입니다.", profitRate);
        printlnMessage(str);
    }
}
