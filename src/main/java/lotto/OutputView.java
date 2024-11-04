package lotto;


import java.util.Map;

public class OutputView {
    public static final String LOTTO_AMOUNT = "개를 구매했습니다.";
    public static final String PRIZE_TOTAL = "총 수익률은 %.1f";

    public static void outputLottoAmount(int amount) {
        System.out.println(amount + LOTTO_AMOUNT);
    }

    public static void outputMatchResult(Map<LottoMatch, Integer> match) {
        for (LottoMatch lottoMatch : LottoMatch.values()) {
            int count = match.getOrDefault(lottoMatch, 0);
            System.out.println(lottoMatch + "" + count + "개");
        }
    }

    public static void outputPrizeTotal(double rateOfReturn) {
        System.out.printf(PRIZE_TOTAL, rateOfReturn);
        System.out.print("%입니다.");
    }
}
