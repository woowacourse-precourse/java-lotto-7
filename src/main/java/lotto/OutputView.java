package lotto;


import java.util.Map;

public class OutputView {
    public static final String LOTTO_AMOUNT = "개를 구매했습니다.";
    public static final String PRIZE_TOTAL = "총 수익률은 %.1f";
    public static final String NUMBER_RANGE_OVER = "[ERROR] 숫자는 1부터 45 사이의 숫자여야 합니다.";
    public static final String NUMBER_SIZE_WRONG = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String NUMBER_OVERLAP = "[ERROR] 로또 번호에 중복이 있습니다.";
    public static final String BONUS_NUMBER_OVERLAP = "[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.";

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
