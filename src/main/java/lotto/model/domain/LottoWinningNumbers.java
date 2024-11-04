package lotto.model.domain;

import lotto.dto.LottoWinningNumbersDto;

import static lotto.Constants.MAXIMUM_LOTTO_NUMBER;
import static lotto.Constants.MINIMUM_LOTTO_NUMBER;
import static lotto.LottoInputErrorMessage.*;

public class LottoWinningNumbers {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public LottoWinningNumbers(LottoWinningNumbersDto dto) {
        this.winningNumbers = new Lotto(dto.winningNumbers().numbers());
        this.bonusNumber = dto.bonusNumber();
        validateBonusNumber();
    }

    private void validateBonusNumber() {
        if (bonusNumber < MINIMUM_LOTTO_NUMBER || bonusNumber > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LOTTO_BONUS_NUMBER_RANGE_ERROR.getFormattedMessage(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER));
        }
        if (containsNumber(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_BONUS_NUMBER_DUPLICATE_ERROR.getMessage());
        }
    }

    private boolean containsNumber(int number) {
        return winningNumbers.getNumbers().contains(number);
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}