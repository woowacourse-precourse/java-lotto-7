package lotto.dto;

import lotto.domain.PurchaseAmount;

public class PurchaseAmountDto {

    public int value;

    public PurchaseAmountDto(final int value) {
        this.value = value;
    }

    public PurchaseAmount toEntity() {
        return new PurchaseAmount(value);
    }
}
