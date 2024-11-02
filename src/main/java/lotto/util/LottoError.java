package lotto.util;

public enum LottoError {
    NUMBER_COUNT_ERROR("형식 오류 : 로또 번호는 6개 입니다."),
    NUMBER_FORMAT_ERROR("형식 오류 : 숫자를 입력하세요."),
    WINNING_NUMBER_INPUT_FORMAT_ERROR("형식 오류 : 양수 6개를 ,로 구분하여 입력하세요."),
    DIVIDE_1000_ERROR("형식 오류 : 금액은 1000원 단위여야 합니다."),
    NUMBER_RANGE_ERROR("범위 오류 : 번호는 1부터 45 사이의 숫자여야 합니다."),
    PAYMENT_RANGE_ERROR("범위 오류 : 지불 금액은 0보다 커야 합니다."),
    NUMBER_DUPLICATED_ERROR("중복 오류 : 로또 번호는 중복될 수 없습니다."),
    BONUS_DUPLICATED_ERROR("중복 오류 : 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    LottoError(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
