package lotto.exception;

import static java.lang.String.format;
import static lotto.controller.util.WinningNumberSplitter.DELIMITER;
import static lotto.domain.constant.LottoRule.*;

public enum ExceptionMessage {

    INPUT_BLANK("값을 입력하지 않으셨습니다."),
    INVALID_NUMBER_FORMAT("유효하지 않은 숫자입니다."),
    DUPLICATED_LOTTO_NUMBER("로또 번호는 중복될 수 없습니다."),
    NO_MORE_LOTTO("더이상 존재하는 로또가 없습니다."),

    INVALID_DELIMITER_FORMAT(
            format("숫자만 입력할 수 있으며, 구분자는 %s만 사용할 수 있습니다.", DELIMITER)
    ),
    INVALID_WINNING_NUMBER_FORMAT(
            format("잘못된 입력 형식입니다: %s다음 숫자를 입력해 주세요.", DELIMITER)
    ),
    INVALID_PURCHASING_UNIT(
            format("%d원 단위로 구매해주세요.", TICKET_PRICE.getNumber())
    ),
    INVALID_PURCHASING_PRICE(
            format("최소 %d원부터 최대 %d원까지 구매 가능합니다.", TICKET_PRICE.getNumber(), MAXIMUM_PURCHASE_PRICE.getNumber())
    ),
    INVALID_LOTTO_SIZE(
            format("로또 번호는 %d개여야 합니다.", LOTTO_SIZE.getNumber())
    ),
    NUMBER_OUT_OF_RANGE(
            format("로또 숫자 범위는 최소 %d부터 최대 %d까지 가능합니다.",
                    MIN_NUMBER.getNumber(),
                    MAX_NUMBER.getNumber())
    );

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final String message;

    ExceptionMessage(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage() {
        return format(message);
    }
}
