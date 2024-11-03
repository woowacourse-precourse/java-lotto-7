package lotto.exception;

public enum ErrorMessage {
    // InputHelper Error
    NOT_NUM("숫자가 아닙니다."),
    NOT_INPUT_FORMAT("형식에 맞지 않습니다."),
    NOT_NATURAL_NUM("자연수로 입력해주세요."),


    // LottoMachine Error
    ILLEGAL_GAMBLING("복권 100장 초과 구매는 불법입니다."),
    UNDIVIDED_THOUSAND("복권은 한장당 1000원입니다."),
    NOT_INIT_STATE("초기 설정이 되지않은 상태입니다"),

    // Lotto Error
    NOT_SIX_NUM("복권은 6개의 숫자로 이루어져있습니다."),
    NOT_IN_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    EXIST_NUM("중복된 숫자가 있습니다."),
    ;

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
