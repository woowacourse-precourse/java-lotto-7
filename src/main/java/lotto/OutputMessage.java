package lotto;

public enum OutputMessage {
    PURCHASE_MESSAGE("개를 구매했습니다."),
    ACCOUNT_MESSAGE("당첨 통계\n---"),
    RATE_OF_RETURN_MESSAGE("총 수익률은 "),
    FINISH_MESSAGE("입니다.");

    private final String message;

    OutputMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
