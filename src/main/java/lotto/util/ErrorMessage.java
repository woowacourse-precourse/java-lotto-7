package lotto.util;

public enum ErrorMessage {

    NOT_NUMBER("[ERROR] 정수만 가능합니다."),
    MONEY_IS_NOT_MOD_PRICE("[ERROR] 돈은 천원 단위로 입력해야 합니다."),
    LOTTO_IS_NOT_FIT_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_NUMS_DUPLICATION("[ERROR] 로또 번호가 중복됩니다."),
    LOTTO_NUM_OUT_OF_RANGE(String.format("[ERROR] 로또 번호는 %d와 %d 사이의 숫자여야 합니다.",
            Constants.LOTTO_RANGE_START, Constants.LOTTO_RANGE_END)),
    LOTTO_NUM_IS_NOT_NUM("[ERROR] 로또 번호는 숫자여아 합니다.");

    private final String msg;

    ErrorMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    private static class Constants {
        public static final int LOTTO_RANGE_START = 1;
        public static final int LOTTO_RANGE_END = 45;
    }
}
