package lotto.utils;

public enum ErrorMessage {
    EMPTY_INPUT_ERROR_MESSAGE("빈 문자열 및 공백은 입력할 수 없습니다."),
    PURCHASE_AMOUNT_ERROR_MESSAGE("1000원 단위의 금액을 입력해주세요."),
    DELIMITER_ERROR_MESSAGE("쉼표(,)를 기준으로 구분해서 입력해주세요."),
    WINNING_NUMBER_COUNT_ERROR_MESSAGE("당첨 번호는 6개여야 합니다."),
    WINNING_NUMBER_ERROR_MESSAGE("당첨 번호는 1부터 45 사이의 숫자이며, 서로 중복되지 않아야 합니다."),
    BONUS_NUMBER_ERROR_MESSAGE("보너스 번호는 1부터 45사이의 숫자이며, 당첨 번호와 중복되지 않아야 합니다."),
    LOTTO_NUMBER_ERROR_MESSAGE("발행한 로또 번호는 1부터 45사이 6개의 숫자이며, 서로 중복되지 않아야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return Constant.ERROR_MESSAGE_PREFIX + this.message;
    }
}
