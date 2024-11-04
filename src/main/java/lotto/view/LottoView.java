package lotto.view;

import lotto.Lotto;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoResult;

import java.util.Map;

public class LottoView {

    public static void printErrorMessage(String message) {
        System.out.println(ErrorMessage.ERROR_MESSAGE_PREFIX + message);
    }

    public static void printLottoStatistics(Map<LottoResult, Integer> statistics) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + statistics.get(LottoResult.THREE) + "개");
        System.out.println("4개 일치 (50,000원) - " + statistics.get(LottoResult.FOUR) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + statistics.get(LottoResult.FIVE) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + statistics.get(LottoResult.FIVE_AND_BONUS) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + statistics.get(LottoResult.ALL) + "개");
    }

    public static void printLottoBenefitRate(Map<LottoResult, Integer> statistics, Integer payment) {
        int sum = calculateBenefitRate(statistics);
        Double rate = sum / (double)payment * 100;

        System.out.println("총 수익률은 " + rate + "%입니다.");
    }

    private static Integer calculateBenefitRate(Map<LottoResult, Integer> statistics) {
        int result = 0;
        for (Map.Entry<LottoResult, Integer> entry : statistics.entrySet()) {
            result += entry.getKey().getPrice() * entry.getValue();
        }
        return result;
    }

}
