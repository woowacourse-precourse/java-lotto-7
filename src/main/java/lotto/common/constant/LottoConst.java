package lotto.common.constant;

public class LottoConst {

    public static final int START_NUM = 1;
    public static final int END_NUM = 45;
    public static final int LOTTO_NUM_COUNT = 6;
    public static final int LOTTO_PRICE = 1000;


    public static final String DELIMITER = ",";
    public static final String JOINING_DELIMITER = ", ";


    public static final String ERROR_PREFIX = "[ERROR] ";


    public static final String LOTTO_AMOUNT_REQUEST = "구입금액을 입력해 주세요.";
    public static final String LOTTO_WINNING_NUMBER_REQUEST = "당첨 번호를 입력해 주세요.";
    public static final String LOTTO_BONUS_NUMBER_REQUEST = "보너스 번호를 입력해 주세요.";


    public static final String NOT_NUMBER_MSG = "올바른 숫자를 입력해주세요.";
    public static final String CANT_DIVIDE_MSG = String.format("로또의 한 장당 가격은 %d원 입니다. %d원 단위로 입력해주세요.",
            LottoConst.LOTTO_PRICE, LottoConst.LOTTO_PRICE);


    public static final String LOTTO_INVALID_QUANTITY_MSG = "로또 번호는 6개여야 합니다.";
    public static final String LOTTO_NOT_DISTINCT_NUMBERS_MSG = "로또 번호는 중복되지 않아야 합니다.";
    public static final String INVALID_WINNING_NUMBER_FORMAT_MSG = "당첨 번호는 모두 숫자여야 합니다.";
    public static final String INCORRECT_BONUS_NUMBER_MSG = "보너스 번호는 1부터 45번까지의 숫자여야 합니다.";
    public static final String DUPLICATED_BONUS_NUMBER_MSG = "보너스 번호는 당첨 번호에서 중복되지 않은 숫자여야 합니다.";

}
