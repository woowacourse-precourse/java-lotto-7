package lotto.entity;

import java.util.Set;

public class WinningLotto {
    private final Set<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Set<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank getRank(Set<Integer> userNumbers) {
        int matchCount = calculateMatchCount(userNumbers);
        boolean hasBonus = userNumbers.contains(bonusNumber);
        return Rank.getRank(matchCount, hasBonus);
    }

    private int calculateMatchCount(Set<Integer> userNumbers) {
        int matchCount = 0;
        for (Integer number : userNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public void printWinningStatistics(int[] matchCounts) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", matchCounts[Rank.FIFTH.ordinal()]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", matchCounts[Rank.FOURTH.ordinal()]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", matchCounts[Rank.THIRD.ordinal()]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", matchCounts[Rank.SECOND.ordinal()]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", matchCounts[Rank.FIRST.ordinal()]);
    }
}
