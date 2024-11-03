package lotto.exception;

public enum LottoErrorMessages {
    ERROR_UNIT("[ERROR] "),
    PAY_INPUT_ERROR("숫자만 입력 가능합니다."),
    NOT_THOUSAND("최소 천원 이상부터 구매가 가능합니다."),
    NOT_ENABLE_AMOUNT_START("수동 구매 갯수는 0부터 "),
    NOT_ENABLE_AMOUNT_END("사이의 숫자만 입력할 수 있습니다."),
    NUMBER_RANGE_ERROR("1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_IS_DUPLICATED_ERROR("로또 번호로 입력한 번호는 보너스 번호로 등록할 수 없습니다."),
    DUPLICATED_NUMBER_ERROR("중복된 번호가 있습니다."),
    SYNTAX_NUMBER_ERROR("쉼표로 구분된 6개의 숫자만 입력할 수 있습니다."),
    ;

    private String text;

    LottoErrorMessages(String text) {
        this.text = text;
    }

    public String addErrorText() {
        return ERROR_UNIT.text + this.text;
    }
    public String text(){
        return this.text;
    }
}
