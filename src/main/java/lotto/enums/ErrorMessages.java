package lotto.enums;

import java.text.MessageFormat;

public enum ErrorMessages {

    INPUT_NOTHING("입력 문자열은 null이거나 비어있어서는 안 됩니다."),
    MONEY_UNIT("구입 금액의 최소 단위는 {0}원입니다."),
    NUMBER_FORMAT("입력은 숫자만 가능합니다."),

    LOTTO_SIZE("로또 번호의 개수는 {0}개이어야 합니다."),
    LOTTO_BOUND("로또 번호의 범위는 {0}부터 {1}까지입니다."),
    LOTTO_UNIQUE_WINNING_NUMBER("당첨 로또 번호에 중복된 번호가 존재합니다."),
    LOTTO_UNIQUE_BONUS_NUMBER("당첨 로또 번호에 존재하는 번호입니다.")
    ;
    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage(Object... params) {
        return MessageFormat.format("[ERROR] " + this.message, params);
    }
}