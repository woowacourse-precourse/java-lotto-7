package lotto.Constants;

/**
 * 사용자에게 출력할 메시지를 정의한 enum
 */
public enum Message {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASED_LOTTO("개를 구매했습니다."),
    WINNING_STATISTICS("당첨 통계"),;
    private final String text;

    Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
