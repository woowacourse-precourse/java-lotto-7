package lotto.domain.purchase;

import java.util.Objects;

public class LottoMoney {
    private static final int UNIT_THOUSAND = 1000;
    private final int money;

    public static LottoMoney of(int money) {
        return new LottoMoney(money);
    }

    private LottoMoney(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (isThousandUnit(money)) {
            throw new IllegalArgumentException("돈은 1000 단위어야 합니다");
        }
    }

    private static boolean isThousandUnit(int money) {
        return (money % UNIT_THOUSAND) != 0;
    }

    public int getValue() {
        return money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoMoney that = (LottoMoney) o;
        return money == that.money;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(money);
    }
}
