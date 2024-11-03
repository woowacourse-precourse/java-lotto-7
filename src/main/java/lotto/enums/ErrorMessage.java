package lotto.enums;

public enum ErrorMessage {
    LOTTO_SIZE_ERROR("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_RANGE_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBER_DUPLICATE_ERROR("로또 번호는 중복될 수 없습니다."),
    LOTTO_BONUS_NUMBER_DUPLICATE_ERROR("당첨 번호와 중복됩니다."),
    MONEY_UNIT_ERROR("금액은 1000원 단위로 입력해주세요.\n"),
    WINNING_NUMBER_TYPE_ERROR("당첨 번호는 숫자로 입력해주세요.\n"),
    BONUS_NUMBER_TYPE_ERROR("보너스 번호는 숫자로 입력하주세요.\n"),
    MONEY_TYPE_ERROR("금액은 숫자로 입력해주세요.\n");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR_PREFIX + message;
    }
}