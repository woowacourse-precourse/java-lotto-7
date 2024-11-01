package lotto.exception;

public enum LottoErrorMessage {
    LOTTO_NUMBER_SIZE_ERROR("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45사이여야 합니다."),
    LOTTO_NUMBER_DUPLICATE_ERROR("[ERROR] 로또 번호는 중복될 수 없습니다."),
    LOTTO_BONUS_NUMBER_DUPLICATE_ERROR("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    LOTTO_BONUS_NUMBER_RANGE_ERROR("[ERROR] 보너스 번호는 1부터 45사이여야 합니다.");

    private final String message;

    LottoErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
