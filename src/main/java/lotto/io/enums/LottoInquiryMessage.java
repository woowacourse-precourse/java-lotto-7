package lotto.io.enums;

public enum LottoInquiryMessage {

    PURCHASE_AMOUNT_INQUIRY("구입금액을 입력해 주세요."),
    WINNING_NUMBERS_INQUIRY("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INQUERY("보너스 번호를 입력해 주세요.");

    private final String msg;

    LottoInquiryMessage(String msg) {
        this.msg=msg;
    }

    public String getMsg(){
        return msg;
    }
}
