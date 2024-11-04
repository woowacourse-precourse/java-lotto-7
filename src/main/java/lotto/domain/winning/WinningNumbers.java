package lotto.domain.winning;

import static lotto.common.exception.ErrorMessage.WINNING_NUMBERS_CANNOT_BE_DUPLICATED;
import static lotto.common.exception.ErrorMessage.WINNING_NUMBERS_SIZE_MUST_BE_SIX;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.common.exception.LottoException;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

public class WinningNumbers {

    private static final int INITIAL_COUNT = 0;
    private static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> winningNumbers;

    public WinningNumbers(List<LottoNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
        validateDuplicate();
        validateSize();
    }

    public int calculateMatchCount(Lotto lotto) {
        int count = INITIAL_COUNT;
        for (LottoNumber lottoNumber : lotto.getLotto()) {
            if (winningNumbers.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    private void validateSize() {
        if (winningNumbers.size() != LOTTO_SIZE) {
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
