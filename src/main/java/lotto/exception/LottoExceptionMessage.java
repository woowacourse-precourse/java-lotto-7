package lotto.exception;

public enum LottoExceptionMessage {


    LOTTO_NUM_OUT_OF_RANGE("로또 번호의 숫자는 1~45 사이의 값 이이야 합니다."),
    LOTTO_NUM_DUPLICATED("중복된 숫자가 포함되어 있습니다."),
    LOTTO_NUM_LENGTH_NOT_SATISFIED("로또 번호는 6개여야 합니다."),
    LOTTO_NUM_PARSE_ERROR("유효하지 않은 입력이 존재합니다."),
    PURCHASING_MONEY_LASTED("구입 금액은 1,000원 단위이어야 합니다.");
    private final String message;

    public String getMessage(){
        return "[ERROR] "+ this.message;
    }
    LottoExceptionMessage(String message){
        this.message=message;
    }
}
