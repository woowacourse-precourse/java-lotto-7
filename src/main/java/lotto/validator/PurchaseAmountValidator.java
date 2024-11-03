package lotto.validator;

public class PurchaseAmountValidator implements Validator {
    private static final String AMOUNT_NEGATIVE = "[ERROR] 구매 금액은 음수가 될 수 없습니다.";
    private static final String AMOUNT_NOT_MULTIPLE_OF_1000 = "[ERROR] 구매 금액이 1,000원 단위가 아닙니다.";
    private static final String AMOUNT_OVER_LIMIT = "[ERROR] 구매 금액이 너무 큽니다.";
    private static final Long limitAmount = 4611686000L;
    private final Long amount;

    public PurchaseAmountValidator(Long amount) {
        this.amount = amount;
    }

    @Override
    public void validate() {
        validateAmountIsNegative();
        validateAmountMultipleOfThousand();
        validateAmountGreaterThanLimit();
    }

    private void validateAmountIsNegative() throws IllegalArgumentException {
        if(amount < 0){
            throw new IllegalArgumentException(AMOUNT_NEGATIVE);
        }
    }

    private void validateAmountMultipleOfThousand() throws IllegalArgumentException {
        if(amount % 1000 != 0){
            throw new IllegalArgumentException(AMOUNT_NOT_MULTIPLE_OF_1000);
        }
    }

    private void validateAmountGreaterThanLimit() throws IllegalArgumentException {
        if (amount > limitAmount) {
            throw new IllegalArgumentException(AMOUNT_OVER_LIMIT);
        }
    }

}
