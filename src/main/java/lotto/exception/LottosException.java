package lotto.exception;

public class LottosException {

    private static final String MESSAGE_LOTTOS_TICKETS = "[ERROR] 로또 발행 개수와 로또 구매 수량이 일치하지 않습니다.";

    public static void exceptionLottosSize() {
        throw new IllegalArgumentException(MESSAGE_LOTTOS_TICKETS);
    }


}
