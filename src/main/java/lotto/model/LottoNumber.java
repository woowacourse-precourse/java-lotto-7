package lotto.model;

import lotto.util.NumberUtil;

public class LottoNumber {
    private final int value;

    public LottoNumber(int value) {
        this.value = value;
    }

    public static LottoNumber of(String value) {
        return new LottoNumber(NumberUtil.parseInt(value));
    }
}
