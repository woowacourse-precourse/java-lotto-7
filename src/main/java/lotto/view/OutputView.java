package lotto.view;

import java.util.List;

public class OutputView {

    public void printLottoCount(int lottoCount) {
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public void printWinningStatisticsHeader() {
        System.out.println("\n당첨 통계\n---");
    }

    public void printMatchResult(int matchCount, int winningAmount, int winningCount) {
        System.out.println(matchCount + "개 일치 (" + winningAmount + "원) - " + winningCount + "개");
    }

    public void printMatchWithBonusResult(int matchCount, int winningAmount, int winningCount) {
        System.out.println(matchCount + "개 일치, 보너스 볼 일치 (" + winningAmount + "원) - " + winningCount + "개");
    }

    public void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

    public void printExceptionMessage(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }
}
