package lotto.utils;

public enum LottoMessages {
    ENTER("\n"),
    PURCHASED_LOTTO_COUNT("개를 구매했습니다."),
    ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ENTER_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계"),
    LINE_SEPARATOR("-"),
    TOTAL_PROFIT_RATE("총 수익률은 "),
    END_MESSAGE("입니다.");
    private String message;
    LottoMessages(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
