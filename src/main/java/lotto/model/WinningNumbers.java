package lotto.model;

import static lotto.exception.ExceptionErrorMessage.DUPLICATED_LOTTO_NUMBER_MESSAGE;

import java.util.HashSet;
import java.util.Set;

public class WinningNumbers {
    private final Lotto winningLottoNumber;
    private final int bonusLottoNumber;

    public WinningNumbers(Lotto winningLottoNumber, int bonusLottoNumber) {
        validateWinningNumbersAndBonusNumber(winningLottoNumber, bonusLottoNumber);
        this.winningLottoNumber = winningLottoNumber;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public Lotto getWinningLottoNumber() {
        return winningLottoNumber;
    }

    public int getBonusLottoNumber() {
        return bonusLottoNumber;
    }

    private void validateWinningNumbersAndBonusNumber(Lotto winningNumbers, int bonusNumber) {
        Set<Integer> winningNumber = new HashSet<>(winningNumbers.getLottoNumbers());
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER_MESSAGE.toString());
        }
    }
}
