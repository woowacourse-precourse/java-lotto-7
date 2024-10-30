package lotto.Enum;

public enum PrintConstants {
    INPUT_PRICE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_NUMBER_OF_TICKETS("개를 구매했습니다."),
    OUTPUT_ERNING_RATE_1("총 수익률은 "),
    OUTPUT_ERNING_RATE_2("%입니다."),
    ALERT_WINNING_TOTAL("당첨 통계\n---");


    private final String message;

    PrintConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
