package lotto.service;

import lotto.global.WinValue;

import java.util.ArrayList;
import java.util.List;

public class LottoMatch {
    public int count;
    public ArrayList<List<Integer>> lotto = new ArrayList<>();
    public List<Integer> winLotto;
    public int bonusNumber;
    private final int[] winCounts = new int[5];
    private int totalPrize;

    public LottoMatch(int count, ArrayList<List<Integer>> lotto, List<Integer> winLotto, int bonusNumber) {
        this.count = count;
        this.lotto = lotto;
        this.winLotto = winLotto;
        this.bonusNumber = bonusNumber;
    }

    public void match() {
        totalPrize = 0;

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
    }

    public int getTotalPrize() {
        return totalPrize;
    }

    public int[] getWinCounts() {
        return winCounts;
    }

    private Count getCount(List<Integer> iLotto, int matchCount, boolean hasBonus) {
        for (Integer value : iLotto) {
            if (winLotto.contains(value)) matchCount++;
            if (value == bonusNumber) hasBonus = true;
        }
        return new Count(matchCount, hasBonus);
    }

    private record Count(int matchCount, boolean hasBonus) {}

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
}
