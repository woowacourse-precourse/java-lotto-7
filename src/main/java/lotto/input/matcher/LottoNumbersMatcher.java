package lotto.input.matcher;

import lotto.model.Lotto;

import java.util.Objects;

public class LottoNumbersMatcher {

    public Boolean isMatched(Integer target, Lotto matchingLotto) {
        for (Integer number : matchingLotto.getNumbers()) {
            if(Objects.equals(target, number))
                return true;
            if(target < number)
                return false;
        }
        return false;
    }

    public Integer runByLottoNumbers(Lotto winningNumbers, Lotto trialLotto) {
        int matchCount = 0;
        for (Integer number : winningNumbers.getNumbers()) {
            if(isMatched(number, trialLotto))
                matchCount++;
        }
        return matchCount;
    }

    public Boolean runByBonusNumbers(Integer bonusNumber, Lotto trialLotto) {
        for (Integer trialNumber : trialLotto.getNumbers())
            if (Objects.equals(trialNumber, bonusNumber))
                return true;

        return false;
    }
}
