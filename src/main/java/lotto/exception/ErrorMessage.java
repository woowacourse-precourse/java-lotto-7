package lotto.exception;

public enum ErrorMessage {
    INVALID_MONEY_AMOUNT("로또 구입 금액은 1,000원 단위여야 합니다."),
    INVALID_MONEY_FORMAT("로또 구입 금액은 숫자로 입력해야 합니다."),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("로또 번호에는 중복이 없어야 합니다."),
    OUT_OF_RANGE_LOTTO_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    OUT_OF_RANGE_BONUS_NUMBER("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    ;

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
