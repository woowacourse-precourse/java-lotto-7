package validator;

import java.util.List;

public class FirstRankLottoValidator {

    private static final String BONUS_NUMBER_DUPLICATED_ERROR_MESSAGE = "보너스 번호는 당첨 번호와 겹칠 수 없습니다.";

    private static final LottoValidator LOTTO_VALIDATOR = new LottoValidator();

    public FirstRankLottoValidator() {
    }

    public void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        LOTTO_VALIDATOR.validateNumber(bonusNumber);
        validateBonusNumberDuplicated(numbers, bonusNumber);
    }

    private void validateBonusNumberDuplicated(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED_ERROR_MESSAGE);
        }
    }
}
