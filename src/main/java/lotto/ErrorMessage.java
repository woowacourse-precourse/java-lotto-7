package lotto;

public enum ErrorMessage {
    AMOUNT_INPUT_EXCEPTION("[ERROR] 로또는 1장 당 1000원입니다. 1000원 단위로 입력해주세요."),
    AMOUNT_NEGATIVE_EXCEPTION("[ERROR] 로또를 살 수 없습니다! 최소 1000원 이상 입력해주세요."),
    AMOUNT_NOT_NUMBER_EXCEPTION("[ERROR] 숫자만 입력할 수 있습니다. 예) 1000"),
    NUMBER_COUNT_EXCEPTION("[ERROR] 당첨 번호는 6개의 숫자만 가능합니다."),
    NUMBER_DIVISION_EXCEPTION("[ERROR] 당첨 번호를 쉼표(,)로 구분해주세요."),
    INPUT_NOT_NUMBER_EXCEPTION("[ERROR] 당첨 번호는 숫자만 입력할 수 있습니다."),
    NUMBER_RANGE_EXCEPTION("`[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.`"),
    BONUS_NUMBER_COUNT_EXCEPTION("[ERROR] 보너스 번호는 1개의 숫자만 가능합니다.");

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
