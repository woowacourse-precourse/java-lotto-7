package lotto.exception;

public class LotteryMaximumExceededException extends IllegalArgumentException {
    public LotteryMaximumExceededException() {
        super("[ERROR] 구매 가능한 로또 최대 매수 초과입니다. 최대 매수는 100장입니다.");
    }
}
