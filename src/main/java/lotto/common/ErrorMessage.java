package lotto.common;

public enum ErrorMessage {
    // Budget 관련
    BUDGET_NEGATIVE_NUMBER("금액은 음수일 수 없습니다."),
    BUDGET_INVALID_UNIT("금액은 1000원 단위여야 합니다."),

    // Lotto 관련
    LOTTO_HAVE_A_SIX_NUMBERS("로또 번호는 6개여야 합니다."),
    LOTTO_DUPLICATE_NUMBER("로또 번호는 서로 중복될 수 없습니다."),
    LOTTO_OUT_OF_RANGE("로또 번호는 1-45 범위 내 숫자여야 합니다."),

    // 당첨번호 관련
    BUDGET_NUMBER_FORMAT("금액은 숫자로 입력해주세요."),
    WINING_NUMBER_DELIMITER("당첨번호는 ','로 구분된 6개의 숫자여야 합니다."),

    // 보너스번호 관련
    BONUS_NUMBER_IS_NOT_NULL("보너스 번호가 NULL일 수 없습니다."),
    BONUS_NUMBER_OUT_OF_RANGE("보너스 번호는 1-45 범위 내 숫자여야 합니다."),
    BONUS_NUMBER_SHOULD_BE_UNIQUE("보너스 번호와 당첨번호가 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    public String message() {
        return message;
    }
}
