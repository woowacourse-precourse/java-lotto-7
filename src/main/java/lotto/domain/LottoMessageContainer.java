package lotto.domain;

import static lotto.domain.LottoConstants.COUNT_OF_LOTTO_NUMBERS;
import static lotto.domain.LottoConstants.LOTTO_PRICE;
import static lotto.domain.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.view.ViewMessageContainer.ERROR_MESSAGE;

public class LottoMessageContainer {
    public static final String INVALID_PURCHASE_AMOUNT
            = String.format("%s 구입 금액은 %,d원 단위로 입력해야 합니다.", ERROR_MESSAGE, LOTTO_PRICE);
    public static final String COUNT_OF_LOTTO_NUMBERS_ERROR
            = String.format("%s 로또 번호는 %s개여야 합니다.", ERROR_MESSAGE, COUNT_OF_LOTTO_NUMBERS);
    public static final String DUPLICATE_NUMBER_ERROR
            = String.format("%s 로또 번호는 중복되지 않아야 합니다.", ERROR_MESSAGE);
    public static final String OUT_OF_RANGE_NUMBER_ERROR
            = String.format("%s 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", ERROR_MESSAGE, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
    public static final String DUPLICATE_IN_WINNING_NUMBERS_ERROR
            = String.format("%s 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.", ERROR_MESSAGE);
}