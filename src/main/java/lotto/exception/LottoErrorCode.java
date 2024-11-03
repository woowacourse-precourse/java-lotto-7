package lotto.exception;

public enum LottoErrorCode {

    LOTTO_PRICE_NOT_IN_1_000("[ERROR] 로또 가격은 1,000원 단위여야 합니다."),
    LOTTO_PRICE_NOT_BLANK("[ERROR] 구입 금액을 입력해 주세요."),
    LOTTO_PRICE_NOT_POSITIVE_NUMBER("[ERROR] 구입 금액은 숫자여야 합니다."),
    LOTTO_PRICE_NOT_UNDER_1_000("[ERROR] 구입 금액은 1,000원 이상이어야 합니다."),
    LOTTO_PRICE_NOT_OVER_1_000_000("[ERROR] 구입 금액은 1,000,000원 이하이어야 합니다."),

    GENERATED_LOTTO_NUMBERS_SIZE_NOT_6("[ERROR] 로또 번호는 6개여야 합니다."),
    GENERATED_LOTTO_NUMBERS_DUPLICATED("[ERROR] 로또 번호는 중복되지 않아야 합니다."),
    GENERATED_LOTTO_NUMBERS_OUT_OF_RANGE("[ERROR] 로또 번호는 1부터 45 사이여야 합니다."),
    GENERATED_LOTTO_NUMBERS_NOT_SORTED("[ERROR] 로또 번호는 오름차순으로 정렬되어야 합니다."),
    
    ;

    private final String message;

    LottoErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
