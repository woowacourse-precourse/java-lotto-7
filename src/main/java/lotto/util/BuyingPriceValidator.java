package lotto.util;

public class BuyingPriceValidator extends Validator<String> {
    private static final int LOTTO_PRICE_UNIT = 1000;

    @Override
    void validate(String input) {
        validateNull(input);
        validateEmpty(input);
        validateOnlyDigits(input);
        validatePositiveNumber(input);
        validatePriceUnit(input);
    }

    private void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ERROR_PREFIX + "구매 금액을 입력해주세요.");
        }
    }

    private void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_PREFIX + "구매 금액을 입력해주세요.");
        }
    }

    private void validateOnlyDigits(String input) {
        boolean hasNonDigit = input.chars()
                .anyMatch(ch -> !Character.isDigit(ch));

        if (hasNonDigit) {
            throw new IllegalArgumentException(ERROR_PREFIX + "입력은 숫자만 가능합니다.");
        }
    }

    private void validatePositiveNumber(String input) {
        int number = Integer.parseInt(input);
        if (number <= 0) {
            throw new IllegalArgumentException(ERROR_PREFIX + "구매 금액은 0보다 커야 합니다.");
        }
    }

    private void validatePriceUnit(String input) {
        int price = Integer.parseInt(input);
        if (price % LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_PREFIX + "구매는 1,000원 단위로 가능합니다.");
        }
    }
}