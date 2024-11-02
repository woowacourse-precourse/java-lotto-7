package lotto;

import java.util.List;

public class Result {
    private static int six = 0;
    private static int fiveAndBonus = 0;
    private static int five = 0;
    private static int four = 0;
    private static int three = 0;

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
        } else if (matchCount == 5 && isBonusMatch) {
            fiveAndBonus++;
        } else if (matchCount == 5) {
            five++;
        } else if (matchCount == 4) {
            four++;
        } else if (matchCount == 3) {
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
}
