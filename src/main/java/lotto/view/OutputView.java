package lotto.view;

import java.util.Map;
import lotto.domain.Rank;
import lotto.dto.LottoResponse;
import lotto.dto.LottoResult;
import lotto.dto.PurchaseLotto;

public class OutputView {
    private static final String PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String RESULT_MESSAGE_FORMAT = "%s - %d개";
    private static final String PROFIT_MESSAGE_FORMAT = "총 수익률은 %s%%입니다.";

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printPurchaseLotto(PurchaseLotto purchaseLotto) {
        System.out.println(purchaseLotto.purchaseCount() + PURCHASE_COUNT_MESSAGE);
        for (LottoResponse lottoResponse : purchaseLotto.lottoResponses()) {
            System.out.println(lottoResponse.numbers());
        }
    }

    public static void printResult(LottoResult lottoResult) {
        Map<Rank, Integer> result = lottoResult.result();
        for (Rank rank : result.keySet()) {
            System.out.println(String.format(RESULT_MESSAGE_FORMAT, rank, result.get(rank)));
        }
        System.out.println(String.format(PROFIT_MESSAGE_FORMAT, lottoResult.profit()));
    }
}
