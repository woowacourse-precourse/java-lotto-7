package lotto.util;

import lotto.service.LottoMachine;

public enum ErrorMessage {

    IS_NOT_NUMBER("[ERROR] 숫자가 아닌 입력입니다."),
    MONEY_NOT_NUMBER("[ERROR] 구입 금액은 정수만 가능합니다."),
    MONEY_LESS_THEN_MINIMUM(String.format("[ERROR] 구입 금액은 최소 %d원 이상이어야 합니다.", LottoMachine.LOTTO_PRICE)),
    MONEY_MORE_THEN_MAXIMUM(String.format("[ERROR] 로또는 한번에 %d 만원까지 구매할 수 있습니다.", LottoMachine.MONEY_MAX)),
    MONEY_NOT_MODED_PRICE(String.format("[ERROR] 돈은 %d원 단위로 입력해야 합니다.", LottoMachine.LOTTO_PRICE)),
    LOTTO_SIZE_OUT_OF_RANGE("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_NUM_OUT_OF_RANGE(String.format("[ERROR] 로또 번호는 %d와 %d 사이의 숫자여야 합니다.",
            Constants.LOTTO_RANGE_START, Constants.LOTTO_RANGE_END)),
    LOTTO_NUMS_DUPLICATION("[ERROR] 로또 번호가 중복됩니다."),
    LOTTO_BONUS_NUM_DUPLICATION("[ERROR] 보너스 번호가 로또 번호와 중복됩니다."),
    LOTTO_NUM_NOT_NUMBER("[ERROR] 로또 번호는 숫자여야 합니다.");

    private final String msg;

    ErrorMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public static void showErrorMsg(String msg) {
        System.out.println(msg);
    }

    private static class Constants {
        public static final int LOTTO_RANGE_START = 1;
        public static final int LOTTO_RANGE_END = 45;
    }
}
