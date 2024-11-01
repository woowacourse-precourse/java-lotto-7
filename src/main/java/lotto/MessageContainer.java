package lotto;

import static lotto.LottoConstants.COUNT_OF_LOTTO_NUMBERS;

public class MessageContainer {
    public static final String ERROR_LABEL = "[ERROR] ";
    public static final String COUNT_OF_LOTTO_NUMBERS_ERROR
            = String.format("%s로또 번호는 %s개여야 합니다.", ERROR_LABEL, COUNT_OF_LOTTO_NUMBERS);
    public static final String DUPLICATE_NUMBER_ERROR = ERROR_LABEL.concat("로또 번호는 중복되지 않아야 합니다.");
}
