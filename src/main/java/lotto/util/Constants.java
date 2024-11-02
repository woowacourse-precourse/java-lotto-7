package lotto.util;

public enum Constants {
    LOTTO_START("구입금액을 입력해 주세요."),
    LOTTO_COUNT("개를 구매했습니다."),
    LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    LOTTO_BONUS("보너스 번호를 입력해 주세요."),
    LOTTO_RESULT("당첨 통계"),
    ERROR_START("[ERROR} "),
    ERROR_NUMBER("로또 구매 금액은 숫자여야 합니다."),
    ERROR_AMOUNT("로또 구입 금액은 1000원 이상이어야 합니다."),
    ERROR_DIVISIBLE_AMOUNT("로또 구입 금액은 1000원 단위여야 합니다."),
    ERROR_LOTTO_COUNT("로또 번호는 6개여야 합니다."),
    ERROR_LOTTO_NUMBER("로또 번호는 1부터 45까지의 숫자여야 합니다."),
    ;

    private final String message;

    Constants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
