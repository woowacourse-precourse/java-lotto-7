package lotto.error.enums;

public enum LottoErrorMessage {

    MONEY_EXCEPTION("구입 금액은 1,000원의 배수여야 합니다."),
    LOTTO_SIZE_EXCEPTION("로또 번호는 6개여야 합니다."),
    LOTTO_DUPLICATION_EXCEPTION("로또 번호는 중복될 수 없습니다."),
    LOTTO_RANGE_EXCEPTION("로또 번호의 숫자 범위는 1 ~ 45 까지입니다."),
    BONUS_WINNING_CONFLICT_EXCEPTION("보너스 번호는 당첨 번호에 포함될 수 없습니다.");

    private final String msg;

    LottoErrorMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return "[ERROR] "+msg;
    }
}
