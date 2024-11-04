package lotto.constant;

import static lotto.constant.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.MIN_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.PRICE;

public enum ErrorMessage {
    INVALID_PAYMENT_POSITIVE_INTEGER("%s 구입 금액은 양수로 입력해주세요.") {
        public String getFormatMessage() {
            return String.format(this.getMessage(), ERROR_HEADER);
        }
    },
    INVALID_PAYMENT_UNIT("%s 구입 금액은 %,d원 단위로 입력할 수 있습니다.") {
        public String getFormatMessage() {
            return String.format(this.getMessage(), ERROR_HEADER, PRICE);
        }
    },
    INVALID_DRAW_NUMBER_COUNT("%s 당첨 번호는 쉼표로 구분된 %d개의 숫자로 입력해야 합니다.") {
        public String getFormatMessage() {
            return String.format(this.getMessage(), ERROR_HEADER, LOTTO_NUMBER_COUNT);
        }
    },
    INVALID_DRAW_NUMBER_FORMAT("%s 당첨 번호는 %d ~ %d 사이의 양수만 입력 가능합니다.") {
        public String getFormatMessage() {
            return String.format(this.getMessage(), ERROR_HEADER, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
        }
    },
    INVALID_DRAW_NUMBER_DUPLICATE("%s 당첨 번호는 중복되지 않은 %d개의 숫자를 입력해야 합니다.") {
        public String getFormatMessage() {
            return String.format(this.getMessage(), ERROR_HEADER, LOTTO_NUMBER_COUNT);
        }
    },
    INVALID_BONUS_NUMBER_FORMAT("%s 보너스 번호는 %d ~ %d 사이의 양수만 입력 가능합니다.") {
        public String getFormatMessage() {
            return String.format(this.getMessage(), ERROR_HEADER, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
        }
    },
    INVALID_BONUS_NUMBER_DUPLICATE("%s 보너스 번호는 당첨 번호와 중복되지 않는 숫자를 사용해야 합니다.") {
        public String getFormatMessage() {
            return String.format(this.getMessage(), ERROR_HEADER);
        }
    };

    private static final String ERROR_HEADER = "[ERROR]";
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public abstract String getFormatMessage();
}
