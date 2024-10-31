package lotto.exception;

public enum LottoErrorMessage {

    INVALID_INPUT_ERROR("공백이 아닌 값을 입력해주세요."),

    NOT_NUMBER_ERROR("숫자를 입력해주세요."),
    LESS_MIN_AMOUNT_ERROR("1,000원 이상을 입력해주세요."),
    DIV_1_000_AMOUNT_ERROR("1,000원 단위로 입력해주세요."),

    WIN_NUMBERS_CONTAINS_LETTER_ERROR("구분자(',')를 제외한 문자는 입력될 수 없습니다. ','와 숫자만 입력해주세요."),
    WIN_NUMBERS_COUNT_ERROR("당첨 번호는 6개를 입력해주세요."),
    NUMBERS_RANGE_ERROR("1 이상 45 이하의 숫자들만 입력해주세요.");


    private final String error;

    LottoErrorMessage(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
