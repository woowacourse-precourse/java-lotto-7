package lotto.exception;

public class NotEnoughMoneyException extends IllegalArgumentException {
    public NotEnoughMoneyException() {
        super("[ERROR] 금액이 부족합니다.");
    }
}
