package lotto.domain.result;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    private WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto create(List<Integer> numbers, int bonusNumber){
        return new WinningLotto(numbers,bonusNumber);
    }

    public MatchResult getMatchResult(Set<Integer> lottoNumbers){
        List<Integer> numbers = new ArrayList<>(lottoNumbers);
        numbers.retainAll(winningNumbers);

        int matchedNumber = numbers.size();
        boolean isBonusNumberMatched = lottoNumbers.contains(bonusNumber);

        return MatchResult.create(matchedNumber, isBonusNumberMatched);

    }



}
