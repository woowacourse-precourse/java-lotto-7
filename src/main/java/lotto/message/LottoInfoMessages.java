package lotto.message;

public enum LottoInfoMessages {
    INSERT_PAY("구입금액을 입력해 주세요."),
    NOTICE_BUY_AMOUNT_START("개를 구매했습니다. (잔돈 : "),
    NOTICE_BUY_AMOUNT_END("원)"),
    INSERT_MANUAL_AMOUNT_START("수동 번호로 구매할 갯수를 입력해주세요. (최대 "),
    INSERT_MANUAL_AMOUNT_END("개 입력 가능)"),
    INSERT_NUMBERS_START("""
            1~45 사이의 겹치지 않는 6개의 번호를 쉼표로 구분해 입력해주세요.
            Enter를 누르면 자동으로 번호를 입력합니다."""),
    INSERT_NUMBERS_MIDDLE("""
            (수동 구매 갯수가 [\s"""),
    INSERT_NUMBERS_END(" ]개 남았습니다.)"),
    TOTAL_BUY_AMOUNT("""
        [구입 번호 목록]"""),
    INSERT_WINNING_NUMBER("""
            6개의 당첨 번호를 입력해 주세요. (1~45 사이의 겹치지 않는 6개의 숫자를 쉼표로 구분해 입력, Enter를 누르면 자동으로 번호를 입력합니다.)
            """),
    INSERT_BONUS_NUMBER("""
            보너스 번호를 입력해 주세요. (입력된 당첨번호를 제외한 1개의 번호를 입력해주세요. Enter를 누르면 자동으로 번호를 입력합니다.)
            """),
    WINNER_NUMBERS("[당첨 번호]"),
    BONUS_NUMBER("[보너스 번호]"),
    ;

    private String text;

    LottoInfoMessages(String text) {
        this.text = text;
    }

    public String text(){
        return this.text;
    }
}
