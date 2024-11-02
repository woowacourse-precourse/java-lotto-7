package exception;

public class PurchaseAmount {
    public PurchaseAmount(String amount) {
        numberValidate(amount);
        rangeValidate(amount);
        unitValidate(amount);
    }
    private void numberValidate(String amount) {
        if (!amount.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private void rangeValidate(String amount) {
        if (Integer.parseInt(amount) < 1000) {
            throw new IllegalArgumentException("[ERROR] 1000원 이상의 금액만 입력 가능합니다.");
        }
    }

    private void unitValidate(String amount) {
        if (Integer.parseInt(amount) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력 가능합니다.");
        }
    }

}
