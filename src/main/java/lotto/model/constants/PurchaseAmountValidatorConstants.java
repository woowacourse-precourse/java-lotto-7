package lotto.model.constants;

public enum PurchaseAmountValidatorConstants {
    PURCHASE_AMOUNT_NOT_NUMERIC_MESSAGE("구입 금액에는 숫자만 입력할 수 있습니다."),
    PURCHASE_AMOUNT_NOT_IN_RANGE_MESSAGE("1000만원 이상은 구매가 불가능합니다."),
    PURCHASE_AMOUNT_NOT_POSITIVE_MESSAGE ("구입 금액은 양수여야 합니다."),
    PURCHASE_AMOUNT_NOT_MULTIPLE_OF_THOUSAND_MESSAGE("구입 금액은 1,000원 단위여야 합니다.");

    private final String message;

    PurchaseAmountValidatorConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
