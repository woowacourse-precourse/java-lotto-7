package lotto.messages;

public enum SystemMessage {
    INPUT_PRICE("구입금액을 입력해 주세요"),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_NUMBER_RESULT("결과 통계");


    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
