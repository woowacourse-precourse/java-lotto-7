package lotto.enums;

public enum ErrorType {
    INVALID_PURCHASE_RANGE("[ERROR] 구입금액은 1000원 이상이어야 합니다."),
    INVALID_PURCHASE_UNIT("[ERROR] 구입금액은 1000원단위어야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_NUMBER_FORMAT("[ERROR] 로또 번호 입력 형식은 '0,0,0,0,0,0'이어야 합니다."),
    INVALID_LOTTO_BONUS_NUMBER_DUPLICATE("[ERROR] 보너스 번호는 로또 번호와 중복되어선 안됩니다.");

    private final String message;

    ErrorType(String message){
        this.message = message;
    }

    public String getErrorMessage(){
        return message;
    }

}
