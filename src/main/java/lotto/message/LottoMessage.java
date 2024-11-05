package lotto.message;

public enum LottoMessage {

    ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    LOTTO_PURCHASE_SUCCESS("개를 구매했습니다."),
    ENTER_WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    RESULT("\n당첨 통계\n---");

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
