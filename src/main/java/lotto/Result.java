package lotto;

import java.util.List;

public class Result {
    private static int six = 0;
    private static int fiveAndBonus = 0;
    private static int five = 0;
    private static int four = 0;
    private static int three = 0;
    private int amount = 0;

    private static final int FIRST_PLACE_AMOUNT = 2_000_000_000;
    private static final int SECOND_PLACE_AMOUNT = 30_000_000;
    private static final int THIRD_PLACE_AMOUNT = 1_500_000;
    private static final int FOURTH_PLACE_AMOUNT = 50_000;
    private static final int FIFTH_PLACE_AMOUNT = 5_000;

    public Result(int amount) {
        this.amount = amount;
    }

    public static void compareLottoNumber(List<List<Integer>> lottoList, List<Integer> winningNumbers,
                                          int bonusNumber) {
        for (List<Integer> lotto : lottoList) {
            long matchCount = lotto.stream()
                    .filter(winningNumbers::contains)
                    .count();
            boolean isBonusMatch = lotto.contains(bonusNumber);
            updateResults(matchCount, isBonusMatch);
        }
    }

    private static void updateResults(long matchCount, boolean isBonusMatch) {
        if (matchCount == 6) {
            six++;
        }
        if (matchCount == 5 && isBonusMatch) {
            fiveAndBonus++;
        }
        if (matchCount == 5) {
            five++;
        }
        if (matchCount == 4) {
            four++;
        }
        if (matchCount == 3) {
            three++;
        }
    }

    public static void printResults() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + three + "개");
        System.out.println("4개 일치 (50,000원) - " + four + "개");
        System.out.println("5개 일치 (1,500,000원) - " + five + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveAndBonus + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + six + "개");
    }

    public void printRateOfReturn() {
        long profit = (six * FIRST_PLACE_AMOUNT) +
                (fiveAndBonus * SECOND_PLACE_AMOUNT) +
                (five * THIRD_PLACE_AMOUNT) +
                (four * FOURTH_PLACE_AMOUNT) +
                (three * FIFTH_PLACE_AMOUNT);

        double rateOfReturn = ((double) profit / amount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rateOfReturn);
    }
}
