package lotto.error.lotto;

import lotto.domain.lotto.LottoConstant;

public class LottoErrorMessage {
    public final static String INPUT_DATA_IS_NOT_POSITIVE = "[ERROR] 양수로 입력해 주세요.";
    public final static String INVALID_PURCHASE_POLICY =
            "[ERROR] 유효하지 않은 구매금액입니다. " + LottoConstant.LOTTO_PRICE + "원 단위로 입력해 주세요.";
    public final static String INPUT_DATA_IS_NOT_PATTERN = "[ERROR] 유효하지 않은 입력값입니다.";
    public final static String OUT_OF_PURCHASE_LIMIT =
            "[ERROR] 구매개수는 " + LottoConstant.LOTTO_PURCHASE_LIMIT + "장을 초과할 수 없습니다.";
}
