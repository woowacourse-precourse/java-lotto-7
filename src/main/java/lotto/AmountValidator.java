package lotto;

public class AmountValidator {
    private static final String EMPTY_INPUT_ERROR = "[ERROR] 구매 금액을 입력해주세요.";
    private static final String NOT_NUMBER_ERROR = "[ERROR] 금액은 숫자로만 입력해주세요.";
    private static final String COMMA_FORMAT_ERROR = "[ERROR] 천 단위에만 쉼표를 사용해야 합니다.";
    private static final String MINIMUM_AMOUNT_ERROR = "[ERROR] 로또 구입 최소 금액은 1,000원입니다.";
    private static final String AMOUNT_UNIT_ERROR = "[ERROR] 1,000원 단위로 입력해주세요.";
    private static final String NEGATIVE_AMOUNT_ERROR = "[ERROR] 금액은 0 이상의 숫자여야 합니다.";


    public void validateInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }

        if (input.replace(",", "").isEmpty()) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }

        if (!(input.matches("\\d{1,3}(,\\d{3})*") || input.matches("\\d+"))) {
            throw new IllegalArgumentException(COMMA_FORMAT_ERROR);
        }
    }

    public int parseInputToInt(String input) {
        String cleanedInput = input.replaceAll(",", "");
        try {
            return Integer.parseInt(cleanedInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
    }

    public void validateAmount(int lottoAmount) {
        if (lottoAmount < 0) {
            throw new IllegalArgumentException(NEGATIVE_AMOUNT_ERROR);
        }
        if (lottoAmount < 1000) {
            throw new IllegalArgumentException(MINIMUM_AMOUNT_ERROR);
        }
        if (lottoAmount % 1000 != 0) {
            throw new IllegalArgumentException(AMOUNT_UNIT_ERROR);
        }
    }
}
