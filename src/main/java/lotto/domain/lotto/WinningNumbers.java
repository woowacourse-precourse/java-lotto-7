package lotto.domain.lotto;

import static lotto.common.exception.ErrorMessage.WINNING_NUMBERS_CANNOT_BE_DUPLICATED;
import static lotto.common.exception.ErrorMessage.WINNING_NUMBERS_SIZE_MUST_BE_SIX;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.common.exception.LottoException;

public class WinningNumbers {
    private final List<LottoNumber> winningNumbers;

    public WinningNumbers(List<LottoNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
        validateDuplicate();
        validateSize();
    }

    public int calculateMatchCount(Lotto lotto) {
        int count = 0;
        for (LottoNumber lottoNumber : lotto.getLotto()) {
            if (winningNumbers.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    private void validateSize() {
        if (winningNumbers.size() != 6) {
            throw new LottoException(WINNING_NUMBERS_SIZE_MUST_BE_SIX);
        }
    }

    private void validateDuplicate() {
        Set<LottoNumber> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new LottoException(WINNING_NUMBERS_CANNOT_BE_DUPLICATED);
        }
    }

    public List<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }
}
