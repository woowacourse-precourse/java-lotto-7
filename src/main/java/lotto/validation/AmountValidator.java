package lotto.validation;

public class AmountValidator implements Validator<Integer> {
    private static final int LOTTO_PRICE = 1000;
    private static final AmountValidator INSTANCE = new AmountValidator("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");

    private final String errorMessage;

    private AmountValidator(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static AmountValidator getInstance() {
        return INSTANCE;
    }

    @Override
    public void validate(Integer amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
