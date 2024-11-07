package lotto.message;

public enum ErrorMessage {
    NOT_NUMERIC_ERROR("입력 값은 정수여야 합니다."),
    BUY_AMOUNT_NOT_THOUSAND_UNIT("로또 구입 금액은 1000원 단위로 구매해야 합니다."),
    BUY_AMOUNT_LESS_THAN_THOUSAND("로또 구입 금액은 1000원 이상으로 가능합니다."),
    LOTTO_NUMBERS_NOT_FIT_COUNT("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBERS_HAS_DUPLICATE("로또 번호는 중복될 수 없습니다."),
    WINNING_NUMBERS_NOT_FIT_COUNT("당첨 번호는 6개를 입력해야 합니다."),
    WINNING_NUMBERS_HAS_DUPLICATE("당첨 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호는 1 ~ 45 사이의 값만 입력할 수 있습니다."),
    WINNING_NUMBERS_CONTAIN_BONUS_NUMBER("당첨 번호와 보너스 번호는 중복될 수 없습니다.");

    private static final String ERROR_FLAG = "[ERROR] ";

    private String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return String.format(ERROR_FLAG + message);
    }

}
