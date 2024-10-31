package lotto.io;

public enum LottoOutputMessage {

    PURCHASE_AMOUNT_INQUIRY("구입금액을 입력해 주세요."),
    WINNING_NUMBERS_INQUIRY("당첨 번호를 입력해주세요."),
    BONUS_NUMBER_INQUERY("보너스 번호를 입력해주세요.");

    private final String msg;

    LottoOutputMessage(String msg) {
        this.msg=msg;
    }
    public String getMsg(){
        return msg;
    }
}
