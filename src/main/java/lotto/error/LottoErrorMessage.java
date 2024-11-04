package lotto.error;

public enum LottoErrorMessage {

    INVALID_NUMBERS_COUNT("로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBERS("로또 번호는 중복될 수 없습니다."),
    DUPLICATE_WINNING_AND_BONUS_NUMBERS("보너스 번호와 당첨 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_RANGE("번호는 1 ~ 45 범위로 입력해주세요."),
    DUPLICATE_WINNING_NUMBERS("당첨 번호는 중복을 제거하고 입력해주세요"),
    LETTERS_IN_NUMBERS("번호로는 문자를 입력할 수 없습니다."),
    INSUFFICIENT_WINNING_NUMBERS("당첨 번호 개수가 부족합니다."),
    OVERFLOW_WINNING_NUMBERS("당첨 번호 개수가 초과되었습니다."),
    WRONG_WINNING_NUMBERS_FORMAT("잘못된 당첨 번호 형식입니다."),
    EMPTY_NUMBERS("번호를 입력해주세요.");

    private final String message;
    private final String prefix = ErrorMessage.PREFIX.getMessage();

    LottoErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message;
    }
}
