package lotto.exception;

public enum ErrorStatus implements BaseErrorCode {
    //문자열 파싱 관련 예외
    NUMBER_PARSE_ERROR("올바른 형식으로 입력해주세요."),
    NUMBERS_PARSE_ERROR(",로 구분된 숫자들을 입력해주세요."),
    //로또 관련 에러
    LOTTO_OUT_RANGE_ERROR("로또 숫자의 범위가 1~45사이를 벗어납니다."),
    LOTTO_SIZE_ERROR("로또 숫자들의 개수가 여섯개가 아닙니다."),
    LOTTO_UNIQUE_ERROR("로또 숫자들이 서로 겹치지 않아야 합니다."),
    //당첨 번호 관련 에러
    BONUS_NUMBER_UNIQUE_ERROR("보너스 넘버가 겹치지 않아야 합니다."),
    BONUS_NUMBER_OUT_RANGE_ERROR("로또 숫자들이 서로 겹치지 않아야 합니다."),
    //돈 관련 에러
    MONEY_NON_POSITIVE_ERROR("돈은 0 이상이여야 합니다."),
    MONEY_MIN_UNIT_ERROR("돈은 1000원 단위여야 합니다.");
    private final String message;

    ErrorStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String getErrorStatus() {
        return ERROR_PREFIX + message;
    }
}
