package lotto.error.lotto;

import lotto.domain.lotto.LottoConstant;

public class LottoErrorMessage {
    public final static String INPUT_DATA_IS_NOT_POSITIVE = "[ERROR] 양수로 입력해 주세요.";
    public final static String INVALID_PURCHASE_POLICY =
            "[ERROR] 유효하지 않은 구매금액입니다. " + LottoConstant.LOTTO_PRICE + "원 단위로 입력해 주세요.";
    public final static String INPUT_DATA_IS_NOT_PATTERN = "[ERROR] 유효하지 않은 입력값입니다.";
    public final static String DUPLICATED_LOTTO_NUMBERS = "[ERROR] 로또번호는 중복될 수 없습니다.";
    public final static String INVALID_LOTTO_NUMBER_RANGE =
            "[ERROR] 로또 번호는 " + LottoConstant.LOTTO_RANGE_LEFT + "과 " + LottoConstant.LOTTO_RANGE_RIGHT + "사이 입니다.";
    public final static String INVALID_NUMBER_OF_WINNING_NUMBERS =
            "[ERROR] 로또번호는 " + LottoConstant.LOTTO_WINNING_NUMBER_COUNT + "개 입니다.";
    public final static String INPUT_DATA_IS_NOT_POSITIVE_OR_DELIMITER = "[ERROR] 양수와 구분자(,)만으로 입력해 주세요.";
    public final static String OUT_OF_PURCHASE_LIMIT =
            "[ERROR] 구매개수는 " + LottoConstant.LOTTO_PURCHASE_LIMIT + "장을 초과할 수 없습니다.";
}
