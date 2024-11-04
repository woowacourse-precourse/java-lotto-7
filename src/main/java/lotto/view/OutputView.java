package lotto.view;

import java.util.List;
import lotto.constant.LottoOutputMessage;
import lotto.dto.LottoResult;
import lotto.model.Lotto;
import lotto.model.MatchingCountResult;

public class OutputView {
    private static final String PIECE = "개";
    private static final String NEW_LINE = "\n";
    private static final String PERCENT = "%";

    public static void displayPurchaseCount(int count) {
        System.out.println(count + LottoOutputMessage.PURCHASE_AMOUNT_MESSAGE.getMessage());
    }

    public static void displayPurchaseLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void displayResult(LottoResult lottoResult) {
        System.out.println(LottoOutputMessage.LOTTO_WINNING_RESULT_MESSAGE.getMessage());
        System.out.println(LottoOutputMessage.LOTTO_RESULT_BOUNDARY_MESSAGE.getMessage());
        List<MatchingCountResult> matchingCountResults = lottoResult.matchingCountResults();
        for (MatchingCountResult matchingCountResult : matchingCountResults) {
            if (matchingCountResult.getWinningCondition().getMatchCount() > 0) {
                System.out.print(matchingCountResult.getWinningCondition().toString());
                System.out.print(
                        matchingCountResult.getConditionCount() + PIECE + NEW_LINE);
            }
        }
        System.out.println(LottoOutputMessage.LOTTO_RESULT_RATE_MESSAGE.getMessage()
                + lottoResult.rate()
                + PERCENT + LottoOutputMessage.LOTTO_LAST_WORD_MESSAGE.getMessage());
    }
}
