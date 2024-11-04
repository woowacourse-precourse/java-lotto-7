package lotto.constant;

public enum ErrorMessage {
    //구입 금액 에러
    AMOUNT_NON_INTEGER_ERROR("구입 금액은 정수여야 합니다."),
    AMOUNT_BELOW_MINIMUM_ERROR("구입 금액은 1000원 이상이어야 합니다."),
    AMOUNT_NOT_MULTIPLE_OF_LIMIT_ERROR("구입 금액은 1000원 단위어야 합니다."),
    //당첨 번호 에러
    WINNING_NUMBERS_SEPARATOR_ERROR("당첨번호의 구분자는 쉼표여야 합니다."),
    WINNING_NUMBERS_BLANK_ERROR("당첨번호는 비어있을 수 없습니다."),
    WINNING_NUMBERS_SIZE_ERROR("당첨번호는 6개여야 합니다."),
    WINNING_NUMBERS_NON_INTEGER_ERROR("당첨번호는 정수여야 합니다."),
    WINNING_NUMBERS_OUT_OF_RANGE_ERROR("당첨번호는 1이상 45이하여야 합니다."),
    WINNING_NUMBERS_DUPLICATE_ERROR("당첨번호는 서로 중복될 수 없습니다."),
    // 보너스 번호 에러
    BONUS_NUMBER_BLANK_ERROR("보너스 번호는 빈칸일 수 없습니다."),
    BONUS_NUMBER_NON_INTEGER_ERROR("보너스 번호는 정수여야 합니다."),
    BONUS_NUMBER_DUPLICATE_ERROR("보너스 번호는 당첨 번호와 같을 수 없습니다."),
    //로또
    LOTTO_SIZE_LIMIT_ERROR("로또 번호는 6개여야 합니다."),
    LOTTO_EACH_DUPLICATE_ERROR("로또는 중복될 수 없습니다.");


    private final String message;
    private final String PREFIX = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return PREFIX + message;
    }

}
