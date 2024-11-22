package lotto.constants;

import static lotto.constants.LottoConfig.NUMBERS_SIZE;
import static lotto.constants.LottoConfig.NUMBER_RANGE_MAXIMUM;
import static lotto.constants.LottoConfig.NUMBER_RANGE_MINIMUM;
import static lotto.constants.LottoConfig.PRICE_MINIMUM;

public enum ExceptionMessage {

    INVALID_FORMAT_INPUT("숫자를 입력해주세요."),
    HAS_TOO_MANY_NUMBERS(String.format("로또 번호는 %d개만 가능 합니다.", NUMBERS_SIZE)),
    HAS_DUPLICATE_NUMBER("로또 번호는 중복될 수 없습니다."),
    HAS_OUT_OF_RANGE_NUMBER(String.format("로또 번호는 %d ~ %d 사이 숫자만 가능합니다.", NUMBER_RANGE_MINIMUM, NUMBER_RANGE_MAXIMUM)),
    IS_OUT_OF_RANGE_PRICE(String.format("최소 %d원 이상 지불해주세요.", PRICE_MINIMUM)),
    IS_INDIVISIBLE_PRICE("동전은 지불할 수 없습니다."),
    HAS_OUT_OF_RANGE_BONUS_NUMBER(
            String.format("보너스 번호는 %d ~ %d 사이 숫자만 가능합니다.", NUMBER_RANGE_MINIMUM, NUMBER_RANGE_MAXIMUM));

    private static final String EXCEPTION_PREFIX = "[ERROR]";
    private static final String SPACE = " ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.join(SPACE, EXCEPTION_PREFIX, message);
    }
}
