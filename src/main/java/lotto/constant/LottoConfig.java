package lotto.constant;

import java.text.DecimalFormat;

public class LottoConfig {

    public static final int DEFAULT_NUMBER_COUNT = 6;
    public static final int LOTTO_NUMBER_START_INCLUSIVE = 1;
    public static final int LOTTO_NUMBER_END_INCLUSIVE = 45;
    public static final int LOTTO_COST = 1_000;
    public static final DecimalFormat MONEY_FORMAT = new DecimalFormat("###,###");

    private LottoConfig() {
    }
}
