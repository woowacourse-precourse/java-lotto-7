package message;

public enum GameMessage {
    GET_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    GET_LOTTO_MESSAGE("개를 구매했습니다."),
    GET_WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    GET_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    RESULT_AVERAGE_MESSAGE("당첨 통계"),
    RESULT_HYPE_MESSAGE("---"),
    RESULT_COUNT_MESSAGE("개 일치"),
    RESULT_RATE_MESSAGE_START("총 수익률은"),
    RESULT_RATE_MESSAGE_END("%입니다.");

    private String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

