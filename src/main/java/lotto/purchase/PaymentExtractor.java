package lotto.purchase;

import lotto.util.Extractor;

public class PaymentExtractor implements Extractor<Integer> {

    private static final String NUMBER_REGULAR_EXPRESSION = "\\d+";
    private static final String PAYMENT_RULE_REGULAR_EXPRESSION = "^(\\d+)(000)$";

    @Override
    public Integer extract(String input) {
        validateInput(input);
        return Integer.parseInt(input);
    }

    @Override
    public void validateInput(String input) {
        checkNull(input);
        checkBlank(input);
        checkNotNumber(input);
        checkRemainder(input);
        checkZero(input);
    }

    private void checkNotNumber(String input) {
        if (!input.matches(NUMBER_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자만 가능합니다.");
        }
    }

    private void checkRemainder(String input) {
        if (!input.matches(PAYMENT_RULE_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    private void checkZero(String input) {
        if (Integer.parseInt(input) == 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0원이 될 수 없습니다.");
        }
    }
}
