package lotto;

import java.util.List;

public class LottoInputValidator {
    private final String string;

    public LottoInputValidator(String string) {
        validateLottoNumberExists(string);
        validateLottoNumberNumeric(string);
        this.string = string;
    }

    private void validateLottoNumberNumeric(String string) {
        String[] parts = string.split(",");
        for (String part : parts) {
            if (!part.trim().matches("\\d+")) {  // 각 부분이 숫자인지 확인
                throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_FORMAT.getErrorMessage());
            }
        }
    }

    private void validateLottoNumberExists(String string) {
        if (string == null || string.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_INPUT.getErrorMessage());
        }
    }

    public static void validateBonusDuplication(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_BONUS_NUMBER.getErrorMessage());
        }
    }
}
