package lotto.domain;

public enum MoneyErrorConfig {
    ZERO_VALUE_ERROR("[ERROR] 입력 금액은 1원 이상이어야 합니다."),
    STRING_TO_LONG_CONVERT_ERROR("[ERROR] 올바른 숫자를 입력해야 합니다."),
    DIVIDE_1000_ERROR("[ERROR] 1000의 배수인 숫자를 입력해야 합니다.");

    private final String errorMessage;

    MoneyErrorConfig(String moneyError) {
        this.errorMessage = moneyError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
