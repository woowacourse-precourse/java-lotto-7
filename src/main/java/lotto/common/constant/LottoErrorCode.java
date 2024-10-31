package lotto.common.constant;

import lotto.common.exception.LottoException;

public enum LottoErrorCode {
    // 구매 금액 관련 에러
    INVALID_PURCHASE_AMOUNT("P001", "구입금액은 1,000원 단위여야 합니다."),
    NEGATIVE_PURCHASE_AMOUNT("P002", "구입금액은 0보다 커야 합니다."),

    // 로또 번호 관련 에러
    INVALID_NUMBER_RANGE("N001", "번호는 1부터 45 사이의 숫자여야 합니다."),
    NUMBER_DUPLICATE("N002", "번호는 중복될 수 없습니다."),
    INVALID_NUMBER_COUNT("N003", "쉼표(,)를 사용하여 6개의 숫자를 입력해주세요."),

    // 보너스 번호 관련 에러
    BONUS_NUMBER_DUPLICATE("B001", "보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    INVALID_BONUS_NUMBER_RANGE("B002", "보너스 번호는 1부터 45 사이의 자연수여야 합니다."),

    // 입력 형식 관련 에러
    INVALID_INPUT_FORMAT("F001", "자연수를 입력해 주세요."),
    EMPTY_INPUT("F002", "입력값이 비어있습니다.");

    private final String code;
    private final String message;
    private static final String ERROR_PREFIX = "[ERROR] ";

    LottoErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }

    public LottoException throwError() {
        return new LottoException(this);
    }
}