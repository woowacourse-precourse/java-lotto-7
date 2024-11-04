package lotto.io;

import java.util.Map;
import lotto.lotto.Lottos;
import lotto.lotto.Winners;

public class ConsoleOutputHandler implements OutputHandler {

    @Override
    public void showLottoPurchaseComments() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    @Override
    public void showExceptionMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    @Override
    public void showLottoCountComments(int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    @Override
    public void showLottoNumbersComments(Lottos lottos) {
        System.out.println(lottos);
    }

    @Override
    public void showWinningNumbersComments() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    @Override
    public void showBonusNumberComments() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    @Override
    public void showLottoStatistics(Map<String, Integer> rankCount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Winners winner : Winners.values()) {
            if (winner != Winners.NO_RANK) {
                int count = rankCount.getOrDefault(winner.getDescription(), 0);
                System.out.println(winner.formatResult(count));
            }
        }
    }

    @Override
    public void showLottoTotalProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

}
