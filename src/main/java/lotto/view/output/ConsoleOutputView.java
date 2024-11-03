package lotto.view.output;

import java.util.List;
import java.util.Map;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Rank;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printPurchaseGuide() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    @Override
    public void printPurchasedAmount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    @Override
    public void printLottoTicket(List<Lotto> lottoBundle) {
        for (Lotto lotto : lottoBundle) {
            System.out.print("[");
            System.out.print(lotto);
            System.out.println("]");
        }
        System.out.println();
    }

    @Override
    public void printWinningNumbersGuide() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    @Override
    public void printBonusNumberGuide() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    @Override
    public void printWinningStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    @Override
    public void printWinningResult(Map<Rank, Integer> rankCount) {
        System.out.printf("3개 일치 (5,000원) - %d개%n", rankCount.get(Rank.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개%n", rankCount.get(Rank.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", rankCount.get(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", rankCount.get(Rank.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", rankCount.get(Rank.FIRST));
    }

    @Override
    public void printProfitRate(double rate) {
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }

    @Override
    public void printErrorMessage(String message) {
        System.out.println(message);
        System.out.println();
    }

    @Override
    public void printNewLine() {
        System.out.println();
    }
}
