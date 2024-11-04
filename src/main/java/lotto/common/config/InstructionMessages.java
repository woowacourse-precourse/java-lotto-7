package lotto.common.config;

public enum InstructionMessages {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("\n당첨 통계");

    private String message;

    InstructionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
