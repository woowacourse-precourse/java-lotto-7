package lotto.global.util;

public enum ErrorMessage {

    INVALID_AMOUNT_RANGE("[ERROR] 로또는 최소 %s원 최대 %s원 까지 구매할 수 있습니다."),
    INVALID_AMOUNT("[ERROR] 로또는 1,000원 단위로 구매해야 됩니다."),
    OUT_OF_RANGE_NUMBER("[ERROR] 당첨 번호와 보너스 번호는 1~45사이 숫자로 입력해주세요"),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 중복된 숫자는 입력하실 수 없습니다."),
    INVALID_LOTTO_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_NUMBER_FORMAT("[ERROR] 숫자만 입력해주세요");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
