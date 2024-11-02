package lotto;

import static lotto.LottoConstants.COUNT_OF_LOTTO_NUMBERS;
import static lotto.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.LottoConstants.MIN_LOTTO_NUMBER;

public class MessageContainer {
    public static final String ENTER_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.";

    public static final String ERROR_LABEL = "[ERROR] ";
    public static final String COUNT_OF_LOTTO_NUMBERS_ERROR
            = String.format("%s로또 번호는 %s개여야 합니다.", ERROR_LABEL, COUNT_OF_LOTTO_NUMBERS);
    public static final String DUPLICATE_NUMBER_ERROR
            = ERROR_LABEL.concat("로또 번호는 중복되지 않아야 합니다.");
    public static final String OUT_OF_RANGE_NUMBER_ERROR
            = String.format("%s로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", ERROR_LABEL, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
}
