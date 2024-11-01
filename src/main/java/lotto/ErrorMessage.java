package lotto;

public enum ErrorMessage {
    // Budget 관련
    BUDGET_NEGATIVE_NUMBER("[ERROR] 금액은 음수일 수 없습니다."),
    BUDGET_INVALID_UNIT("[ERROR] 금액은 1000원 단위여야 합니다."),

    // Lotto 관련
    LOTTO_HAVE_A_SIX_UMBER("[ERROR] 로또 번호는 6개여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
