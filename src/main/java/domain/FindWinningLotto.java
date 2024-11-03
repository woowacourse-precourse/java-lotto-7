package domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindWinningLotto {

    public enum LottoRank {
        THREE(3, "5,000"),
        FOUR(4, "50,000"),
        FIVE(5, "1,500,000"),
        FIVE_WITH_BONUS(5, "30,000,000"),
        SIX(6, "2,000,000,000");

        private final int matchCount;
        private final String prize;
        private int count;

        LottoRank(int matchCount, String prize) {
            this.matchCount = matchCount;
            this.prize = prize;
            this.count = 0;
        }

        public void incrementCount() {
            this.count++;
        }

        public int getMatchCount() {
            return matchCount;
        }

        public String getPrize() {
            return prize;
        }

        public int getCount() {
            return this.count;
        }

        public static void findWinningLotto(List<List<Integer>> lottoCollection, List<Integer> winningNumberCollection, int bonusNumber) {
            for (List<Integer> lotto : lottoCollection) {
                int countWinningNumber = findWinningNumber(lotto, winningNumberCollection);
                boolean flagBonusNumber = findBonusNumber(lotto, bonusNumber);
                calculateWinningResult(countWinningNumber, flagBonusNumber);
            }
        }

        public static void calculateWinningResult(int countWinningNumber, boolean flagBonusNumber) {
            LottoRank rank = findRankByMatchCount(countWinningNumber, flagBonusNumber);
            if (rank != null) {
                rank.incrementCount();
            }
        }

        public static LottoRank findRankByMatchCount(int countWinningNumber, boolean flagBonusNumber) {
            if (countWinningNumber == 5 && flagBonusNumber) {
                return LottoRank.FIVE_WITH_BONUS;
            }
            if (countWinningNumber == 5 && !flagBonusNumber) {
                return LottoRank.FIVE;
            }
            return Arrays.stream(LottoRank.values())
                    .filter(rank -> rank.getMatchCount() == countWinningNumber)
                    .findFirst()
                    .orElse(null);
        }

        public static int findWinningNumber(List<Integer> lotto, List<Integer> winningNumberCollection) {
            Set<Integer> setWinningNumber = new HashSet<>(winningNumberCollection);
            int countWinningNumber = 0;

            for (int lottoNumber : lotto) {
                if (setWinningNumber.contains(lottoNumber)) {
                    countWinningNumber++;
                }
            }
            return countWinningNumber;
        }

        public static boolean findBonusNumber(List<Integer> lotto, int bonusNumber) {
            return lotto.contains(bonusNumber);
        }
    }
}
