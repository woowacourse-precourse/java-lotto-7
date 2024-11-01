package lotto.utils;

public enum ExceptionMessage {
    INVALID_INPUT_BUDGET("예산은 1000원 단위로 입력 가능합니다."),
    INVALID_DUPLICATED_NUMBER("중복된 숫자는 추가할 수 없습니다."),
    INVALID_LOTTO_NUMBER_RANGE("가능한 로또 번호 범위는 1이상 45이하의 정수입니다."),
    INVALID_BONUS_NUMBER_RANGE("가능한 보너스 번호 범위는 1이상 45이하의 정수입니다."),
    INVALID_BONUS_DUPLICATED_NUMBER("보너스 번호는 정답 번호와 중복될 수 없습니다."),
    INVALID_PARSE_NUMBER("숫자로 변환할 수 없는 값입니다."),
    INVALID_INPUT_WINNING_NUMBER("당첨 번호 입력 형식은 `1,2,3,4,5,6`과 같아야 합니다.");

    private static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return this.message;
    }

}
