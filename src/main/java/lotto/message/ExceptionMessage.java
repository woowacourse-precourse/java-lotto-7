package lotto.message;

import lotto.domain.LottoOption;

public class ExceptionMessage {
    public static final String PREFIX = "[ERROR] ";
    public static final String NOT_A_NUMBER = "숫자를 입력해 주세요.";
    public static final String EMPTY = "빈 값은 허용되지 않습니다.";
    public static final String INVALIDATE_PURCHASE_MONEY_UNIT = "로또 구입 금액은 " + LottoOption.PUCHASE_MONEY_UNIT + "원 단위 이어야합니다.";

    private ExceptionMessage() {

    }
}
