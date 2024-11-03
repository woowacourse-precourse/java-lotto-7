package lotto.constant;

public enum Prompt {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    CONFIRM_TICKET_COUNT("%d개를 구매했습니다."),
    EARNING_RATE("총 수익률은 %.1f%%입니다.");

    private final String message;

    Prompt(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
