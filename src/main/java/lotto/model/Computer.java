package lotto.model;

import java.util.HashMap;
import java.util.List;
import lotto.info.WinningInfo;

public class Computer {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    private HashMap<Integer, Integer> result;   // 순위, 해당 로또 개수

    public Computer(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;

        HashMap<Integer, Integer> tempResult = new HashMap<>();
        for (int i = WinningInfo.FIRST.getRank(); i <= WinningInfo.FIFTH.getRank(); i++) {
            tempResult.put(i, 0);
        }
        this.result = tempResult;
    }

    public void compareToWinningNumbers(List<Lotto> lotto) {
        for (Lotto oneLotto : lotto) {
            int matchCount = getMatchCount(oneLotto.getNumbers());
            boolean bonusMatch = oneLotto.getNumbers().contains(bonusNumber);
            //System.out.println(matchCount + " " + bonusMatch);
            WinningInfo rank = WinningInfo.getRankByMatchCountAndBonus(matchCount, bonusMatch);
            result.put(rank.getRank(), result.get(rank.getRank()) + 1);
        }
        System.out.println(result);
    }

    private int getMatchCount(List<Integer> lottoNumbers) {
        int matchCount = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
