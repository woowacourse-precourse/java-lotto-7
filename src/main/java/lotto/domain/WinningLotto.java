package lotto.domain;

import java.util.List;

import static lotto.domain.message.LottoErrorMessage.INVALID_LOTTO_NUMBER_IN_RANGE;
import static lotto.domain.rule.LottoRules.*;

public class WinningLotto extends Lotto {

    private int  bonusNumber;

    public WinningLotto(List<Integer> numbers) {
        super(numbers);

    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(String bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
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
            throw new IllegalArgumentException("[ERROR] 입력 값이 유효하지 않습니다. 빈 값이나 공백만 입력할 수 없습니다.");
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
            throw new IllegalArgumentException("[ERROR] 정수형식이 아니거나, 너무 큰 숫자입니다.");
        }
    }

    private boolean isBonusNumberInRange(int bonusNumber) {
        return bonusNumber >= MIN_NUMBER.getValue() && bonusNumber <= MAX_NUMBER.getValue();
    }

    private void checkDuplicateWithNumbers(int bonusNumber) {
        if (getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
