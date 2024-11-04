package lotto.EnumManagement;

public enum ExceptionEnum {

    LOTTO_NUMBERS_SIZE_SIX("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_NUMBERS_UNIQUE("[ERROR] 로또 번호는 서로 다르게 입력해야 합니다."),
    INPUT_NUMBER_IS_INTEGER("[ERROR] 정수가 입력돼야 합니다."),
    LOTTO_PURCHASE_UNIT_1000("[ERROR] 1000원 단위로 입력해야 합니다."),
    BONUS_NUMBER_RANGE_1TO45("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBER_RANGE_1TO45("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ALL_LOTTO_NUMBER_IS_INTEGER("[ERROR] 모든 로또 번호는 정수여야 합니다.");

    private final String massage;

    ExceptionEnum(String message) {
        this.massage = message;
    }

    public String getMessage() {
        return massage;
    }

}
