package lotto.util;

public enum Message {
    ERROR_TAG("[ERROR]"),
    BLANK(""),
    WHITE_SPACE(" "),
    COMMA(","),
    COLON_WITH_SPACE(" : "),
    DASH("-"),
    THREE_DASH("---"),
    REQUEST_MONEY_INPUT("구입금액을 입력해 주세요."),
    REQUEST_WINNING_NUMBER_INPUT("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요."),
    TICKET_PURCHASE_RESULT("개를 구매했습니다."),
    STATICS("당첨 통계"),
    MATCH_COUNT("개 일치 ("),
    MATCH_COUNT_WITH_BONUS_NUMBER("개 일치, 보너스 볼 일치 ("),
    MONEY_UNIT("원) - "),
    COUNT_UNIT("개"),
    PROFIT_PREFIX("총 수익률은 "),
    PROFIT_SUFFIX("%입니다."),
    ;

    String sentence;

    Message(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }
}
