package lotto.service;


import lotto.global.WinValue;

import java.util.ArrayList;
import java.util.List;

public class LottoMatch {

    static final String SECOND_OUT_PRINT = "당첨 통계\n---\n";
    public int count;
    public ArrayList<List<Integer>> lotto = new ArrayList<>();
    public List<Integer> winLotto;
    public int bonusNumber;
    private final int[] winCounts = new int[5];


    public LottoMatch(int count, ArrayList<List<Integer>> lotto, List<Integer> winLotto, int bonusNumber) {
        this.count = count;
        this.lotto = lotto;
        this.winLotto = winLotto;
        this.bonusNumber = bonusNumber;
    }

    public void match() {
        int totalPrize = 0;

        for (List<Integer> iLotto : lotto) {
            int matchCount = 0;
            boolean hasBonus = false;

            Count count = getCount(iLotto, matchCount, hasBonus);

            WinValue winValue = getWinValue(count.matchCount(), count.hasBonus());
            if (winValue != null) {
                totalPrize += winValue.getAmount();
                recordWinCount(count.matchCount(), count.hasBonus());
            }
        }

        int total = count * 1000;
        double profitRate = (double) totalPrize / total * 100;

        printStatistics();
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    private Count getCount(List<Integer> iLotto, int matchCount, boolean hasBonus) {
        for (Integer value : iLotto) {
            if (winLotto.contains(value)) matchCount++;
            if (value == bonusNumber) hasBonus = true;
        }
        Count count = new Count(matchCount, hasBonus);
        return count;
    }

    private record Count(int matchCount, boolean hasBonus) {
    }

    private WinValue getWinValue(int matchCount, boolean hasBonus) {
        if (matchCount == 6) return WinValue.SIX;
        if (matchCount == 5 && hasBonus) return WinValue.FIVE_BONUS;
        if (matchCount == 5) return WinValue.FIVE;
        if (matchCount == 4) return WinValue.FOUR;
        if (matchCount == 3) return WinValue.THREE;
        return null;
    }
    private void recordWinCount(int matchCount, boolean hasBonus) {
        if (matchCount == 6) winCounts[4]++;
        else if (matchCount == 5 && hasBonus) winCounts[3]++;
        else if (matchCount == 5) winCounts[2]++;
        else if (matchCount == 4) winCounts[1]++;
        else if (matchCount == 3) winCounts[0]++;
    }
    private void printStatistics() {
        System.out.println(SECOND_OUT_PRINT);
        System.out.printf("3개 일치 (5,000원) - %d개\n", winCounts[0]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", winCounts[1]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", winCounts[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", winCounts[3]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", winCounts[4]);
    }
}
