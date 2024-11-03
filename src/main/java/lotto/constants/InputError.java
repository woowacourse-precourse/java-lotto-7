package lotto.constants;

public enum InputError {
    // 접두사
    ERROR_PREFIX("[ERROR] "),
    // 로또 구입 금액 예외
    PURCHASE_PRICE_SHOULD_EXIST("로또 구입 금액을 입력하셔야 합니다."),
    PURCHASE_PRICE_NOT_A_NUMBER("로또 구입 금액에는 숫자만 입력하셔야 합니다."),
    PURCHASE_PRICE_NOT_REACH_AT_LEAST("최소 한 개 이상의 로또를 구입할 수 있는 가격을 입력하셔야 합니다."
            + "(최소 금액 : "
            + LottoInteger.LOTTO_PRICE.getValue()
            + "원)"),
    PURCHASE_PRICE_OVER_PROGRAM_MAX(Integer.MAX_VALUE
            + " 보다 큰 금액은 지원하지 않습니다."),
    PURCHASE_PRICE_SHOULD_BE_DIVIDED_CLEARLY("로또 구입 금액에는 "
            + LottoInteger.LOTTO_PRICE.getValue()
            + "으로 나눠지는 수를 입력하셔야 합니다."),
    // 로또 당첨 번호 예외
    LOTTO_WIN_NUMBER_SHOULD_EXIST("로또 당첨 번호를 입력하셔야 합니다."),
    LOTTO_WIN_NUMBER_CONTAIN_BAD_INPUT("로또 당첨 번호에는 숫자 "
            + LottoInteger.LOTTO_NUMBER_COUNT.getValue()
            + "개를 구분자를 이용해서 입력하셔야 합니다."),
    LOTTO_WIN_NUMBER_NOT_EQUAL_COUNT("로또 당첨 번호는 정확히 "
            + LottoInteger.LOTTO_NUMBER_COUNT.getValue()
            + " 개를 입력하셔야 합니다."),
    LOTTO_WIN_NUMBER_NOT_IN_BETWEEN_START_AND_END("로또 당첨 번호는 "
            + LottoInteger.LOTTO_START_NUMBER.getValue()
            + "~"
            + LottoInteger.LOTTO_END_NUMBER.getValue()
            + " 사이의 숫자를 입력하셔야 합니다."),
    LOTTO_WIN_NUMBER_NOT_DUPLICATED("로또 당첨 번호는 중복되면 안됩니다."),
    // 보너스 번호 예외
    BONUS_NUMBER_SHOULD_EXIST("보너스 번호를 입력하셔야 합니다."),
    BONUS_NUMBER_NOT_A_NUMBER("보너스 번호는 숫자를 입력하셔야 합니다."),
    BONUS_NUMBER_EXIST_IN_WIN_NUMBERS("보너스 번호가 이미 당첨 번호에 존재합니다."),
    BONUS_NUMBER_NOT_IN_BETWEEN_START_AND_END("보너스 번호는 "
            + LottoInteger.LOTTO_START_NUMBER.getValue()
            + "~"
            + LottoInteger.LOTTO_END_NUMBER.getValue()
            + " 사이의 숫자를 입력하셔야 합니다."),
    ;
    private final String message;

    InputError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX.message + message;
    }
}
