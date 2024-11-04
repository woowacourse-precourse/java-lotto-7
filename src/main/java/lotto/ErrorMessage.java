package lotto;

public enum ErrorMessage {
    LOTTO_LENGTH_ERROR("로또 번호는 %d개여야 합니다."),
    LOTTO_DUPLICATE_ERROR("로또 번호는 중복되지 않아야 합니다."),
    BONUS_NUMBER_DUPLICATE_ERROR("당첨번호와 중복되지 않는 번호를 입력해주세요."),
    LOTTO_NUMBER_RANGE_ERROR("1-45 사이의 값을 입력해주세요."),
    MONEY_UNIT_ERROR("로또는 %d원 단위로 구매가능합니다."),
    NOT_NUMERIC_ERROR("숫자를 입력해주세요"),
    ;
    public static final String HEADER = "[ERROR]";
    private final String message;

    ErrorMessage(String body){
        this.message = String.format("%s %s", HEADER, body);
    }

    public String getMessage() {
        return message;
    }
}
