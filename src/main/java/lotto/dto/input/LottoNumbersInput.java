package lotto.dto.input;

import static lotto.exception.ErrorMessage.*;

public record LottoNumbersInput(String input) {

    public LottoNumbersInput {
        validate(input);
    }

    private void validate(String input) {
        validateLottoNumbersNotNull(input);
        validateLottoNumbersNotEmpty(input);
    }

    private void validateLottoNumbersNotNull(String input) {
        if (input == null) {
            throw new NullPointerException(NULL_INPUT.getMessage());
        }
    }

    private void validateLottoNumbersNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
    }
}
