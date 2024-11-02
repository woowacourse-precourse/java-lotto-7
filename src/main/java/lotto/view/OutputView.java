package lotto.view;

import java.util.List;
import lotto.Lotto;
import lotto.LottoResult;
import lotto.MatchingCountResult;

public class OutputView {
    public static void displayPurchaseCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void displayPurchaseLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void displayResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        List<MatchingCountResult> matchingCountResults = lottoResult.matchingCountResults();
        for (MatchingCountResult matchingCountResult : matchingCountResults) {
            System.out.print(matchingCountResult.winningCondition().toString());
            System.out.print(matchingCountResult.conditionCount() + "개");
        }
        System.out.println("총 수익률은 " + lottoResult.rate() + "%" + "입니다.");
    }
}
