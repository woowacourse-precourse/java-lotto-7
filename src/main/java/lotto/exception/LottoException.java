package lotto.exception;

public class LottoException {

    private static final String MESSAGE_LOTTO_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String MESSAGE_LOTTO_RANGE = "[ERROR] 로또 번호는 1 ~ 45 사이의 숫자여야 합니다.";
    private static final String MESSAGE_LOTTO_DUPLICATE = "[ERROR] 로또 번호는 중복되면 안됩니다.";

    public static void exceptionLottoSize() {
        throw new IllegalArgumentException(MESSAGE_LOTTO_SIZE);
    }

    public static void exceptionLottoRange() {
        throw new IllegalArgumentException(MESSAGE_LOTTO_RANGE);
    }

    public static void exceptionLottoDuplicate() {
        throw new IllegalArgumentException(MESSAGE_LOTTO_DUPLICATE);
    }

}
