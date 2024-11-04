package lotto.domain;

import lotto.dto.BonusNumberDto;

public class BonusNumber {

    private int value;

    public BonusNumber(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public BonusNumberDto toDto() {
        return new BonusNumberDto(value);
    }
}
