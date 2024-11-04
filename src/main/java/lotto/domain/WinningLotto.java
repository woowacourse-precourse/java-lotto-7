package lotto.domain;

import java.util.List;

import static lotto.domain.message.LottoErrorMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.domain.message.LottoErrorMessage.INVALID_LOTTO_NUMBER_IN_RANGE;
import static lotto.domain.rule.LottoRules.*;
import static lotto.utils.DefaultErrorMessage.INVALID_INTEGER_FORMAT;
import static lotto.utils.DefaultErrorMessage.NULL_OR_EMPTY_INPUT;

public class WinningLotto extends Lotto {

    private int bonusNumber;

    public WinningLotto(List<Integer> numbers) {
        super(numbers);

    }

    public void setBonusNumber(String bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateBonusNumber(String inputBonusNumber) {
        validateNullOrEmpty(inputBonusNumber);
        validateParsableToInt(inputBonusNumber);
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        validateBonusNumberInRange(bonusNumber);
        checkDuplicateWithNumbers(bonusNumber);
    }

    private void validateNullOrEmpty(String bonusNumber) {
        if (!isNotNullOrEmpty(bonusNumber)) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_INPUT.getMessage());
        }
    }

    private void validateBonusNumberInRange(int bonusNumber) {
        if (!isBonusNumberInRange(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_IN_RANGE.getMessage());
        }
    }

    private boolean isNotNullOrEmpty(String bonusNumber) {
        return bonusNumber != null && !bonusNumber.isEmpty();
    }

    private void validateParsableToInt(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INTEGER_FORMAT.getMessage());
        }
    }

    private boolean isBonusNumberInRange(int bonusNumber) {
        return bonusNumber >= MIN_NUMBER.getValue() && bonusNumber <= MAX_NUMBER.getValue();
    }

    private void checkDuplicateWithNumbers(int bonusNumber) {
        if (getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }
}
