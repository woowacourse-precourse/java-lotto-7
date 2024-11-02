package lotto;

public class AmountValidator {
    private static final String EMPTY_INPUT_ERROR = "[ERROR] 구매 금액을 입력해주세요.";
    private static final String NOT_NUMBER_ERROR = "[ERROR] 금액은 숫자로만 입력해주세요.";
    private static final String MINIMUM_AMOUNT_ERROR = "[ERROR] 로또 구입 최소 금액은 1,000원입니다.";
    private static final String AMOUNT_UNIT_ERROR = "[ERROR] 1,000원 단위로 입력해주세요.";
    private static final String NEGATIVE_AMOUNT_ERROR = "[ERROR] 금액은 0 이상의 숫자여야 합니다.";

    public void validateInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }
    }

    public int parseInputToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
    }

    public void validateAmount(int lottoAmount) {
        if (lottoAmount < 0) {
            throw new IllegalArgumentException(NEGATIVE_AMOUNT_ERROR);
        }
        if (lottoAmount <= 1000) {
            throw new IllegalArgumentException(MINIMUM_AMOUNT_ERROR);
        }
        if (lottoAmount % 1000 != 0) {
            throw new IllegalArgumentException(AMOUNT_UNIT_ERROR);
        }
    }
}
