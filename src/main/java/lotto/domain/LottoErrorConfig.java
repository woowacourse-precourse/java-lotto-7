package lotto.domain;

public enum LottoErrorConfig {
    LOTTO_SIZE_ERROR("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_RANGE_ERROR("[ERROR] 로또 숫자 범위는 1~45여야 합니다."),
    LOTTO_SORTING_ERROR("[ERROR] 로또 번호는 오름차순 정렬이어야 합니다."),
    LOTTO_DUPLICATED_ERROR("[ERROR] 로또 번호는 서로 다른 숫자여야 합니다.");

    private final String errorMessage;

    LottoErrorConfig(String error) {
        this.errorMessage = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
