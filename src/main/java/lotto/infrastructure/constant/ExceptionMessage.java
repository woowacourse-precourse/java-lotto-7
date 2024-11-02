package lotto.infrastructure.constant;

import lotto.domain.cost.Cost;
import lotto.domain.lotto.vo.LottoNumber;

public final class ExceptionMessage {
    public static final String DUPLICATE = "서로 중복된 숫자가 존재합니다.";

    public static final String PURCHASE_LESS_THAN_ONE = "구입 금액은 양의 정수만 입력할 수 있습니다.";

    public static final String PURCHASE_MORE_THAN_MAX = String.format("구입 금액이 최대 금액 %d보다 큽니다.", Cost.MAX);

    public static final String INVALID_INTEGER = "올바른 정수 값이 아닙니다.";

    public static final String EMPTY_INPUT = "빈 값은 입력할 수 없습니다.";

    public static final String INVALID_LOTTO_COUNT = String.format("로또 번호는 %d개여야 합니다.", LottoConfig.COUNT);

    public static final String INVALID_PURCHASE_UNIT = String.format("구입 금액은 %d 단위의 정수만 가능합니다.", Cost.UNIT);

    public static final String OUT_OF_RANGE_LOTTO_NUMBER =
            String.format("로또 번호는 %d ~ %d 사이의 숫자만 입력할 수 있습니다.", LottoNumber.MIN, LottoNumber.MAX);
}
