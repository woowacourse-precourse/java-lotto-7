package lotto.models;

import lotto.utils.Prize;

import java.util.ArrayList;
import java.util.List;

public class StatisticsCalculator {

    private final Statistics statistics;
    public StatisticsCalculator(Statistics statistics) {
        this.statistics = statistics;
    }

    public void calculateStatistics(List<List<Integer>> allIssuedLotto, List<Integer> winningNumbers, int bonusNumber) {
        for (List<Integer> issuedLotto : allIssuedLotto) {
            int matchCount = countMatches(issuedLotto, winningNumbers);
            boolean bonusMatch = issuedLotto.contains(bonusNumber);

            Prize prize = Prize.match(matchCount, bonusMatch);
            if (prize != null && statistics != null) {
                statistics.increment(prize);
            }
        }
    }

    private int countMatches(List<Integer> issuedLotto, List<Integer> winningNumbers) {
        int count = 0;
        for (Integer number : issuedLotto) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

}
