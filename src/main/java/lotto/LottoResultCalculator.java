package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoResultCalculator {

    public enum WinningLevel {
        FIRST(6, 2000000000, "6개 일치"),
        SECOND(5, 30000000, true, "5개 일치, 보너스 볼 일치"),
        THIRD(5, 1500000, "5개 일치"),
        FOURTH(4, 50000, "4개 일치"),
        FIFTH(3, 5000, "3개 일치"),
        NONE(0, 0, "일치하지 않음");

        private final int matchingNumbers;
        private final int prize;
        private final boolean bonus;
        private final String description;

        WinningLevel(int matchingNumbers, int prize, boolean bonus, String description) {
            this.matchingNumbers = matchingNumbers;
            this.prize = prize;
            this.bonus = bonus;
            this.description = description;
        }

        WinningLevel(int matchingNumbers, int prize, String description) {
            this(matchingNumbers, prize, false, description);
        }

        public int getPrize() {
            return prize;
        }

        public String getFormattedPrize() {
            return String.format("%,d원", getPrize());
        }

        public String getDescription() {
            return description;
        }

        public static WinningLevel findLevel(int matchCount, boolean hasBonus) {
            for (WinningLevel level : values()) {
                if (level.matchingNumbers == matchCount && (!level.bonus || hasBonus)) {
                    return level;
                }
            }
            return NONE;
        }
    }

    public HashMap<WinningLevel, Integer> prepareResultStorage() {
        HashMap<WinningLevel, Integer> matches = new HashMap<>();
        for (WinningLevel level : WinningLevel.values()) {
            matches.put(level, 0);
        }
        return matches;
    }

    public void calculateWinnings(ArrayList<Lotto> myLotto, List<Integer> winningNumberList, int bonusNumber, int price) {
        HashMap<WinningLevel, Integer> matches = prepareResultStorage();
        for (Lotto singleLotto : myLotto) {
            int matchCount = singleLotto.countMatches(winningNumberList);
            boolean hasBonus = singleLotto.getNumbers().contains(bonusNumber);
            WinningLevel level = WinningLevel.findLevel(matchCount, hasBonus);
            matches.put(level, matches.get(level) + 1);
        }
        printStatus(matches, price);
    }

    public void printStatus(HashMap<WinningLevel, Integer> matches, int price) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (WinningLevel level : matches.keySet()) {
            if (level != WinningLevel.NONE) {
                int count = matches.getOrDefault(level, 0);
                System.out.println(level.getDescription() + " (" + level.getFormattedPrize() + ") - "
                        + count + "개");
            }
        }
        printProfitRate(matches, price);
    }

    public void printProfitRate(HashMap<WinningLevel, Integer> matches, int price) {
        int totalPrize = calculateTotalPrize(matches);
        double profitRate = ((double) totalPrize / price) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }

    public int calculateTotalPrize(HashMap<WinningLevel, Integer> matches) {
        int totalPrize = 0;
        for (WinningLevel level : matches.keySet()) {
            totalPrize += matches.get(level) * level.getPrize();
        }
        return totalPrize;
    }
}
