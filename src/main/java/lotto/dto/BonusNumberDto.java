package lotto.dto;

import lotto.domain.BonusNumber;

public class BonusNumberDto {

    public int value;

    public BonusNumberDto(final int value) {
        this.value = value;
    }

    public BonusNumber toEntity() {
        return new BonusNumber(this.value);
    }
}
