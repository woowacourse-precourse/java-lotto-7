package lotto.enums;

public enum LottoErrorMessage {

    LOTTOS_INVALID_SIZE("[ERROR] 로또는 한개 이상 천개 이하로 사야합니다."),
    INVALID_NUMBER("[ERROR] 로또 당첨 숫자는 1과 45 사이의 값이어야 합니다."),
    INVALID_BUY_NUMBER("[ERROR] 로또 구매 금액은 천원 단위여야 합니다."),
    INVALID_LOTTO_COUNT("[ERROR] 로또 구매는 최대 천개까지입니다"),
    DUPLICATE_NUMBERS("[ERROR] 로또 번호에 중복된 숫자가 있어서는 안 됩니다."),
    LOTTO_WINNING_INVALID_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_BONUS_INVALID_SIZE("[ERROR] 보너스 번호는 1개의 숫자로 이루어져야 합니다."),
    NOT_POSITIVE("[ERROR] 숫자는 양수여야합니다"),
    NOT_A_NUMBER("[ERROR] 입력값은 양수 숫자여야 합니다");

    private final String errorMsg;

    LottoErrorMessage(String msg) {
        this.errorMsg = msg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
