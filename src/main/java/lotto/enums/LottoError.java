package lotto.enums;

import java.util.regex.Pattern;

public enum LottoError {

    // lotto purchase price
    LOTTO_PURCHASE_PRICE_NOT_DIVISIBLE("로또 구입 가격이 로또 가격으로 나누어지지 않습니다."),
    LOTTO_PURCHASE_PRICE_LESS_THAN_MIN("로또 구입 가격이 최소값 미만입니다."),
    LOTTO_PURCHASE_PRICE_MORE_THAN_MAX("로또 구입 가격이 최대값 이상입니다."),

    // lotto bundle
    LOTTO_BUNDLE_LOTTOS_COUNT_INVALID("로또의 구매 갯수와 발급된 로또의 수가 다릅니다."),

    // lotto numbers
    LOTTO_NUMBERS_COUNT("로또 번호의 수가 일치하지 않습니다."),
    LOTTO_NUMBERS_DUPLICATION("로또 번호들에 중복이 포함되어 있습니다."),

    // lotto number
    LOTTO_NUMBER_LESS_THAN_MIN("로또 번호가 최소값 미만입니다."),
    LOTTO_NUMBER_MORE_THAN_MAX("로또 번호가 최대값 초과입니다."),

    // lotto bonus number
    LOTTO_BONUS_NUMBER_DUPLICATION("로또 보너스 번호가 중복되었습니다."),

    // input validator
    INPUT_NUMBER_INVALID("입력된 번호의 형식이 올바르지 않습니다."),
    INPUT_NUMBERS_INVALID("입력된 번호들의 형식이 올바르지 않습니다."),

    // input parser
    INVALID_NUMBER("유효하지 않은 수의 형식입니다.");

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] %s";
    private static final String ERROR_MESSAGE_FORMAT_TEXT = "\\[ERROR\\] .+";
    private static final Pattern ERROR_MESSAGE_FORMAT = Pattern.compile(ERROR_MESSAGE_FORMAT_TEXT);
    private String message;


    LottoError(String message) {
        this.message = message;
    }

    public static Pattern getErrorMessageFormat() {
        return ERROR_MESSAGE_FORMAT;
    }

    public String getMessage() {
        return String.format(ERROR_MESSAGE_PREFIX, message);
    }


}
