package lotto.utils;

public class InputValidator {

    public void validatePurchaseAmount(String userInput) {
        validateEmpty(userInput);
    }

    private void validateEmpty(String userInput) {
        if (userInput.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT_ERROR_MESSAGE.getMessage());
        }
    }
}
