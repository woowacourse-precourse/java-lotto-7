package lotto.util;

public enum ErrorMessage {
    LOTTO_NUMBER_COUNT(
            "[R0001]",
            "로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_RANGE(
            "[R0002]",
            "로또 번호는 1에서 45 사이여야 합니다."),
    BONUS_NUMBER_RANGE(
            "[R0003]",
            "보너스 번호는 1에서 45 사이여야 합니다."),
    MONEY_RANGE(
            "[R0004]",
            "보너스 번호는 1에서 45 사이여야 합니다."),
    UNIQUE_LOTTO_NUMBER(
            "[U0001]",
            "로또 번호는 중복 될 수 없습니다."),
    UNIQUE_BONUS_NUMBER(
            "[U0002]",
            "보너스 번호는 당첨 번호와 중복 될 수 없습니다."),
    INVALID_NUMBER(
            "[F0001]",
            "부정확한 숫자가 입력되었습니다."),
    WINNING_NUMBER_FORMAT(
            "[F0002]",
            "당첨 로또 번호는 숫자와 콤마만 입력가능합니다."),
    MONEY_UNIT(
            "[F0003]",
            "로또 구입은 1000원 단위로 가능합니다."),

    ;

    String errorCode;
    String errorMessage;

    ErrorMessage(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getError() {
        return Message.ERROR_TAG.getSentence() + errorCode + Message.WHITE_SPACE.getSentence() + errorMessage;
    }
}