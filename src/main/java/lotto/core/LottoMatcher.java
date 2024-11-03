package lotto.core;

import java.util.List;

public class LottoMatcher {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    public LottoMatcher(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers=winningNumbers;
        this.bonusNumber=bonusNumber;
    }
    public LottoResult match(List<Integer> userNumbers){
        int matchCount = (int) userNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
        boolean isBonusMatched=userNumbers.contains(bonusNumber);
        return new LottoResult(matchCount, isBonusMatched);
    }
}
