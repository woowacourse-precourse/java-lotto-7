package lotto.constant;

import lotto.vo.Money;

public final class LottoConstants {
    public static final Money SINGLE_TICKET_PRICE = Money.from(1_000);

    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;

    public static final int NUMBERS_PER_TICKET = 6;
}
