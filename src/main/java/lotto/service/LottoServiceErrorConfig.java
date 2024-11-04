package lotto.service;

public enum LottoServiceErrorConfig {
    COMMA_SPLIT_ERROR("[ERROR] 6개의 숫자 사이에 ',' 가 올바르게 들어있어야 합니다."),
    STRING_TO_INT_CONVERT_ERROR("[ERROR] 올바른 숫자를 입력하셔야 합니다."),
    LOTTO_NUMBER_RANGE_ERROR("[ERROR] 로또 숫자 범위는 1~45여야 합니다.");

    private final String errorMessage;

    LottoServiceErrorConfig(String error) {
        this.errorMessage = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
