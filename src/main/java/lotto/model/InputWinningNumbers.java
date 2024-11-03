package lotto.model;

import static lotto.constants.ErrorMessage.INPUT_CAN_NOT_BE_BLANK;

import java.util.Objects;

public class InputWinningNumbers {

    private final String inputWinningNumbers;

    public InputWinningNumbers(String inputWinningNumbers) {
        validateIsBlank(inputWinningNumbers);
        this.inputWinningNumbers = inputWinningNumbers;
    }

    private void validateIsBlank(String inputWinningNumbers) {
        if (inputWinningNumbers == null || inputWinningNumbers.isBlank()) {
            throw new IllegalArgumentException(INPUT_CAN_NOT_BE_BLANK.get());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InputWinningNumbers comparingWinningNumbers = (InputWinningNumbers) obj;
        return Objects.equals(inputWinningNumbers, comparingWinningNumbers.inputWinningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputWinningNumbers);
    }

    public String getInputWinningNumbers() {
        return inputWinningNumbers;
    }
}
