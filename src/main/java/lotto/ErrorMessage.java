package lotto;

public enum ErrorMessage {
    // Budget 관련
    BUDGET_NEGATIVE_NUMBER("금액은 음수일 수 없습니다."),
    BUDGET_INVALID_UNIT("금액은 1000원 단위여야 합니다."),

    // Lotto 관련
    LOTTO_HAVE_A_SIX_NUMBERS("로또 번호는 6개여야 합니다."),
    LOTTO_DUPLICATE_NUMBER("로또 번호는 서로 중복될 수 없습니다."),
    LOTTO_OUT_OF_RANGE("로또 번호는 1-45 범위 내 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    public String message() {
        return message;
    }
}
