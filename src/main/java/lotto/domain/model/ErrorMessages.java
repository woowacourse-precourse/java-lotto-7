package lotto.domain.model;

public enum ErrorMessages {
    INVALID_LOTTO_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."), INVALID_NUMBER_RANGE(
            "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."), INVALID_PURCHASE_AMOUNT(
            "[ERROR] 구입 금액은 1000원 단위여야 합니다."), ZERO_PURCHASE_AMOUNT(
            "[ERROR] 구입 금액이 0일 수 없습니다."), MINIMUM_PURCHASE_AMOUNT(
            "[ERROR] 구입 금액은 1000원 이상이어야 합니다."), INVALID_INPUT_FORMAT("[ERROR] 잘못된 입력 형식입니다."), EMPTY_INPUT(
            "[ERROR] 입력은 빈 값일 수 없습니다."), DUPLICATE_WINNING_NUMBER_ERROR(
            "[ERROR] 당첨 번호는 중복될 수 없습니다."), BONUS_NUMBER_DUPLICATE_ERROR("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
