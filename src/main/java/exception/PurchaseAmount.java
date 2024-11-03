package exception;

public class PurchaseAmount {
    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final int ONE_LOTTO= 1000;

    public PurchaseAmount(String amount) {
        emptyValidate(amount);
        numberValidate(amount);
        rangeValidate(amount);
        unitValidate(amount);
    }

    private void emptyValidate(String amount) {
        if (amount.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 비어있습니다.");
        }
    }

    private void numberValidate(String amount) {
        if (!amount.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private void rangeValidate(String amount) {
        if (Integer.parseInt(amount) < ONE_LOTTO) {
            throw new IllegalArgumentException("[ERROR] 1000원 이상의 금액만 입력 가능합니다.");
        }
    }

    private void unitValidate(String amount) {
        if (Integer.parseInt(amount) % ONE_LOTTO != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력 가능합니다.");
        }
    }
}
