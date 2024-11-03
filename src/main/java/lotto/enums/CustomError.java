package lotto.enums;

public enum CustomError {
    INVALID_PURCHASE_INPUT("[ERROR] 구입 금액은 1,000원 단위입니다. 유효한 금액을 입력해주세요."),
    INVALID_LOTTO_NUM_INPUT("[ERROR] 당첨 번호는 1부터 45까지의 중복되지 않는 6개의 숫자이어야 합니다. 번호는 쉼표(,)를 기준으로 구분해주세요."),
    INVALID_BONUS_NUM_INPUT("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1부터 45까지의 숫자이어야 합니다."),
    INVALID_LOTTO_LIST_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_LIST_INPUT("[ERROR] 로또 번호는 1~45 사이의 양수여야 합니다.");

    private String errorMessage;

    CustomError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
