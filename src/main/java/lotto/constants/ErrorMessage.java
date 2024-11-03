package lotto.constants;

public enum ErrorMessage {

    ERROR_PREFIX("[ERROR]"),
    INVALID_LOTTO_NUMBER(" 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_BUDGET(" 금액은 1,000의 배수만 입력 가능합니다."),
    INVALID_LOTTO_NUMBER_COUNT(" 로또 번호는 6개여야 합니다."),
    EMPTY_INPUT_VALUE_ERROR(" 빈 문자열이 입력되었습니다."),
    INVALID_INPUT_LOTTO_STRING(" 로또 번호 입력이 잘못 되었습니다."),
    INVALID_NUMBER(" 문자에서 정수로 변환이 불가능 합니다."),
    ZERO_BUDGET_ERROR(" 구입금액 0원은 불가능합니다."),
    DUPLICATE_LOTTO_NUMBER(" 로또 번호가 중복되었습니다.");
    private String errorMessage;

    ErrorMessage(String message){
        this.errorMessage = message;
    }

    public String getErrorMessage(){
        return errorMessage;
    }

}
