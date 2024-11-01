package lotto.exception;

import java.util.List;

public class LotteryNumbersDuplicationException extends IllegalArgumentException {
    public LotteryNumbersDuplicationException(List<Integer> numbers) {
        super("[ERROR] 당첨 번호는 중복이 안됩니다.");
    }
}
