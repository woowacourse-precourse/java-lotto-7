package lotto.message;

public enum ErrorMessage {
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    INVALID_INPUT("잘못된 입력입니다."),
    INVALID_THOUSAND("1000원 단위로 입력해주세요. "),
    NEGATIVE_NUMBER("1000 이상의 숫자를 입력해주세요."),
    INVALID_LOTTO_NUMBER_RANGE("1 ~ 45 사이의 숫자만 입력해주세요."),
    DUPLICATE_NUMBER("중복된 숫자가 있습니다."),
    ;

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return ERROR_PREFIX + message;
    }
}
