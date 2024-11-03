package lotto.enums;

public enum ErrorType {
    INVALID_PURCHASE_RANGE("[ERROR] 구입금액은 1000원 이상이어야 합니다."),
    INVALID_PURCHASE_UNIT("[ERROR] 구입금액은 1000원단위어야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_NUMBER_FORMAT("[ERROR] 로또 번호 입력 형식은 '0,0,0,0,0,0'이어야 합니다."),
    INVALID_LOTTO_BONUS_NUMBER_DUPLICATE("[ERROR] 보너스 번호는 로또 번호와 중복되어선 안됩니다."),
    UNEXPECTED_ERROR("[ERROR] 예기치 못한 에러로 종료됩니다."),
    INVALID_PRICE_FORMAT("[ERROR] 금액의 형식이 올바르지 않습니다."),
    INVALID_DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호를 중복으로 작성할 수 없습니다.");


    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return message;
    }

}