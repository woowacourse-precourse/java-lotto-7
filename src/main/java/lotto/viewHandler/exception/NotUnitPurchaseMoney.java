package lotto.viewHandler.exception;

public class NotUnitPurchaseMoney extends MyException {
    public NotUnitPurchaseMoney() {
        super();
    }

    public NotUnitPurchaseMoney(String message) {
        super(message);
    }

    public NotUnitPurchaseMoney(String message, Throwable cause) {
        super(message, cause);
    }

    public NotUnitPurchaseMoney(Throwable cause) {
        super(cause);
    }
}
