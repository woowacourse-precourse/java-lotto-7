package lotto.message;

public enum OutputMessage {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_LOTTO("개를 구매했습니다."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_RESULT("당첨 통계"),
    TOTAL_PROFIT_RATE("총 수익률은 %.1f%%입니다.");

    ;

    private final String message;

    OutputMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
