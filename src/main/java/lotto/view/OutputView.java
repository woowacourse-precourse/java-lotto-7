package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] ";
    private static final String OUTPUT_LOTTO_PURCHASE_AMOUNT = "개를 구매했습니다.";
    private static final String OUTPUT_LOTTO_RESULT_HEAD = "당첨 통계\n---";
    private static final String OUTPUT_LOTTO_RESULT_FIFTH = "3개 일치 (5,000원) - ";
    private static final String OUTPUT_LOTTO_RESULT_FORTH = "4개 일치 (50,000원) - ";
    private static final String OUTPUT_LOTTO_RESULT_THIRD = "5개 일치 (1,500,000원) - ";
    private static final String OUTPUT_LOTTO_RESULT_SECOND = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String OUTPUT_LOTTO_RESULT_FIRST = "6개 일치 (2,000,000,000원) - ";
    private static final String OUTPUT_LOTTO_RESULT_REVENUE = "총 수익률은 ";
    private static final String OUTPUT_LOTTO_RESULT_REVENUE_TAIL = "%입니다.";
    private static final String OUTPUT_LOTTO_RESULT_COUNT = "개";

    public static void outputLottoPurchaseAmount(int amount) {
        System.out.println(amount + OUTPUT_LOTTO_PURCHASE_AMOUNT);
    }

    public static void outputPurchaseLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void outputLottoResult(Map<Rank, Integer> result) {
        System.out.println(OUTPUT_LOTTO_RESULT_HEAD);
        System.out.println(OUTPUT_LOTTO_RESULT_FIFTH + result.get(Rank.FIFTH_PLACE) + OUTPUT_LOTTO_RESULT_COUNT);
        System.out.println(OUTPUT_LOTTO_RESULT_FORTH + result.get(Rank.FOURTH_PLACE) + OUTPUT_LOTTO_RESULT_COUNT);
        System.out.println(OUTPUT_LOTTO_RESULT_THIRD + result.get(Rank.THIRD_PLACE) + OUTPUT_LOTTO_RESULT_COUNT);
        System.out.println(OUTPUT_LOTTO_RESULT_SECOND + result.get(Rank.SECOND_PLACE) + OUTPUT_LOTTO_RESULT_COUNT);
        System.out.println(OUTPUT_LOTTO_RESULT_FIRST + result.get(Rank.FIRST_PLACE) + OUTPUT_LOTTO_RESULT_COUNT);
    }

    public static void outputRevenue(double revenue) {
        System.out.println(OUTPUT_LOTTO_RESULT_REVENUE + revenue + OUTPUT_LOTTO_RESULT_REVENUE_TAIL);
    }

    public static void outputError(String message) {
        System.out.println(ERROR_MESSAGE_FORMAT + message);
    }
}
