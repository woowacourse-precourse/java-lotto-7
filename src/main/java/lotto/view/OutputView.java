package lotto.view;

import java.util.List;
import lotto.dto.LottoResult;
import lotto.dto.MatchingCountResult;
import lotto.model.Lotto;

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
            if (matchingCountResult.getWinningCondition().getMatchCount() > 0) {
                System.out.print(matchingCountResult.getWinningCondition().toString());
                System.out.print(matchingCountResult.getConditionCount() + "개" + "\n");
            }
        }
        System.out.println("총 수익률은 " + lottoResult.rate() + "%" + "입니다.");
    }
}
