package lotto.error;

public enum LottoError {
    INVALID_INPUT_FORMAT("입력 형식이 잘못되었습니다. 숫자만 입력해야 합니다."),
    INVALID_PURCHASE_AMOUNT("구입 금액은 1,000원 단위로 입력해야 합니다."),
    INVALID_NON_POSITIVE_AMOUNT("구입 금액은 0보다 큰 값이어야 합니다."),
    INVALID_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    INVALID_NUMBER_RANGE("로또 번호는 1부터 45 사이여야 합니다."),
    DUPLICATE_NUMBER("중복된 숫자가 없어야 합니다."),
    INVALID_BONUS_NUMBER("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATE("보너스 번호는 이미 뽑힌 당첨 번호와 중복될 수 없습니다."),
    INVALID_NUMBER_PARSE("입력하신 숫자가 유효하지 않습니다.");

    private final String message;

    LottoError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
