package lotto.exception;

public class OutOfRangeLotteryNumberException extends IllegalArgumentException {
    public OutOfRangeLotteryNumberException() {
        super("당첨 번호는 1 ~ 45 범위 내로 입력해주세요.");
    }
}
