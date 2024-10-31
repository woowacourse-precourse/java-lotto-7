package lotto.exception;

public class LotteryMaximumExceededException extends IllegalArgumentException {
    public LotteryMaximumExceededException() {
        super("로또 최대 수량 초과입니다. 최대 수량은 100장입니다.");
    }
}
