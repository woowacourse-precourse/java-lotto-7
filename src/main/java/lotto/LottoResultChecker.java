package lotto;

import java.util.List;

public class LottoResultChecker {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;


    public LottoResultChecker(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private int countMatchingNumbers(List<Integer> userNumbers) {
        int matchCount = 0;
        for (int number : userNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public MatchCountMessage checkRanking(List<Integer> userNumbers) {
        int matchCount = countMatchingNumbers(userNumbers);
        boolean bonusMatch = userNumbers.contains(bonusNumber);

        if (matchCount == 6) {
            return MatchCountMessage.SIX_MATCH;
        }
        if (matchCount == 5 && bonusMatch) {
            return MatchCountMessage.FIVE_MATCH_WITH_BONUS;
        }
        if (matchCount == 5) {
            return MatchCountMessage.FIVE_MATCH;
        }
        if (matchCount == 4) {
            return MatchCountMessage.FOUR_MATCH;
        }
        if (matchCount == 3) {
            return MatchCountMessage.THREE_MATCH;
        }
        return null;
    }
}
