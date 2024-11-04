package lotto.constant;

import static lotto.constant.LottoConstant.MAX_NUMBER;
import static lotto.constant.LottoConstant.MAX_PURCHASE_AMOUNT;
import static lotto.constant.LottoConstant.MIN_NUMBER;
import static lotto.constant.LottoConstant.MIN_PURCHASE_AMOUNT;
import static lotto.constant.LottoConstant.PRICE;
import static lotto.constant.LottoConstant.SIZE_NUMBERS;

public class Error {

    private static final String PREFIX = "[ERROR]";

    public static final String MIN_AMOUNT_PURCHASE = String.format("%s 최소 %d개 이상 구매할 수 있습니다.", PREFIX, MIN_PURCHASE_AMOUNT);
    public static final String MAX_AMOUNT_PURCHASE = String.format("%s 최대 %d개 까지만 구매할 수 있습니다.", PREFIX, MAX_PURCHASE_AMOUNT);
    public static final String INVALID_UNIT_PURCHASE = String.format("%s 반드시 %d원 단위로만 구매할 수 있습니다.", PREFIX, PRICE);

    public static final String SIZE_LOTTO_NUMBERS = String.format("%s 로또 번호는 반드시 %d개여야 합니다.", PREFIX, SIZE_NUMBERS);
    public static final String DUPLICATED_LOTTO_NUMBERS = String.format("%s 로또 번호는 중복될 수 없습니다.", PREFIX);
    public static final String RANGE_LOTTO_NUMBER = String.format("%s 로또 번호는 %d이상 %d이하만 가능합니다.", PREFIX, MIN_NUMBER, MAX_NUMBER);

    public static final String SIZE_WINNING_NUMBERS = String.format("%s 당첨 번호는 반드시 %d개여야 합니다.", PREFIX, SIZE_NUMBERS);
    public static final String DUPLICATED_WINNING_NUMBERS = String.format("%s 당첨 번호는 중복될 수 없습니다.", PREFIX);
    public static final String RANGE_WINNING_NUMBER = String.format("%s 당첨 번호는 %d이상 %d이하만 가능합니다.", PREFIX, MIN_NUMBER, MAX_NUMBER);

    public static final String DUPLICATED_WINNING_BONUS_NUMBERS = String.format("%s 당첨 번호와 보너스 번호는 겹칠 수 없습니다.", PREFIX);
    public static final String RANGE_BONUS_NUMBER = String.format("%s 보너스 번호는 %d이상 %d이하만 가능합니다.", PREFIX, MIN_NUMBER, MAX_NUMBER);

    public static final String TYPE_MISMATCH_INTEGER = String.format("%s 반드시 정수만 입력 가능합니다.", PREFIX);
}
