package lotto.common;

public enum SystemMessage implements Displayable {
    PRE_MONEY_INJECT("구입금액을 입력해 주세요."),
    ENTER_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계\n---");

    private final String message;

    SystemMessage(String message) {
        this.message=message;
    }

    @Override
    public String toPrettyString() {
        return message;
    }
}
