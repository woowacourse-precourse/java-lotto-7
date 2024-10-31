package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Rank;

import java.util.List;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printPurchaseAmount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    @Override
    public void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }

    @Override
    public void printResult(LottoResult result) {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + result.getCountByRank(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.getCountByRank(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.getCountByRank(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " +
                result.getCountByRank(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getCountByRank(Rank.FIRST) + "개");
    }

    @Override
    public void printProfit(double profit) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profit);
    }

    @Override
    public void printError(String message) {
        System.out.println("[ERROR] " + message);
    }
}
