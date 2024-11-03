package lotto.constant;

public enum ErrorMessage {
    EMPTY_INPUT("[ERROR] 값을 입력해 주세요."),
    NOT_RANGE_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_SIX_NUMBER("[ERROR] 로또 번호는 6개여야 합니다."),


    //구입 금액 에러 메시지
    NOT_NATURAL_NUMBER("[ERROR] 구입 금액은 자연수여야 합니다."),
    NOT_THOUSAND_PRICE("[ERROR] 구입 금액은 1,000원 단위여야 합니다."),

    //당첨 번호 에러 메시지
    NOT_COMMA_PARSE("[ERROR] 당첨 번호는 쉼표(,)로만 구분해야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 중복 되는 당첨 번호가 존재합니다."),

    //보너스 번호 에러 메시지
    BONUS_DUPLICATE_WINNING_NUM("[ERROR] 입력하신 보너스 번호와 중복되는 당첨 번호가 존재합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
