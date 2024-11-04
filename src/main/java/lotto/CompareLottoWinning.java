package lotto;

import java.util.List;

public class CompareLottoWinning {
    private final List<Integer> winningNumbers;
    private final CompareBonusWinning compareBonusWinning;
    private final int[] matchCounts;

    public CompareLottoWinning(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.compareBonusWinning = new CompareBonusWinning(bonusNumber);
        this.matchCounts = new int[6];
    }

    public void calculateResults(List<List<Integer>> generatedLottos) {
        for (List<Integer> lottoNumbers : generatedLottos) {
            int matchCount = countMatchingNumbers(lottoNumbers);
            boolean bonusMatched = compareBonusWinning.isBonusMatched(lottoNumbers);

            if (matchCount == 6) {
                matchCounts[1]++;
            } else if (matchCount == 5 && bonusMatched) {
                matchCounts[2]++;
            } else if (matchCount == 5) {
                matchCounts[5]++;
            } else if (matchCount == 4) {
                matchCounts[4]++;
            } else if (matchCount == 3) {
                matchCounts[3]++;
            }
        }
    }
    private int countMatchingNumbers(List<Integer> lottoNumbers) {
        int matchCount = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
    public int[] getMatchCounts() {
        return matchCounts;
    }
    }