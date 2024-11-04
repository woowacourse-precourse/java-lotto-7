package lotto.dto;

import lotto.configuration.Prize;

public record PrizeCountEntry(Prize prize, int count) {
    public PrizeCountEntry {
        if (prize == null) {
            throw new IllegalArgumentException("prize cannot be null");
        }
    }
}
