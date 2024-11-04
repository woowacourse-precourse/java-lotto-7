package lotto.constants;

public enum ErrorStringConstants {
    PURCHASE_AMOUNT_ERROR_MESSAGE("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."),
    NUMBER_ERROR_MESSAGE("[ERROR] 올바른 숫자를 입력해야 합니다."),
    RANGE_ERROR_MESSAGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_ERROR_MESSAGE("[ERROR] 로또 번호와 보너스 번호는 중복되지 않아야 합니다.");

    private String value;

    ErrorStringConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
