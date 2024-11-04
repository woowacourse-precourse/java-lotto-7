package lotto.global;

public enum ErrorMessage {
    ILLEGAL_LOTTO_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ILLEGAL_PRICE_ERROR("[ERROR] 로또 구입 금액을 정확하게 입력해주세요."),
    EMPTY_INPUT_VALUE("[ERROR] 입력이 비어있습니다."),
    INVALID_PRICE_ERROR("[ERROR] 로또 구입 금액은 1000원 단위로 나누어 떨어져야 합니다."),
    DUPLICATED_LOTTO_NUMBER("[ERROR] 중복된 로또 번호를 입력하였습니다."),
    HAS_SIX_LOTTO_NUMBER("[ERROR] 로또 번호는 6개여야 합니다.");

    public final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
