package lotto.dto;

import lotto.domain.Prize;

public record PrizeResponse(int matchingNumberCount, boolean containsBonusNumber, int prizeMoney) {
    public PrizeResponse(Prize prize, boolean containsBonusNumber) {
        this(prize.getMatchingNumberCount(), containsBonusNumber, prize.getPrizeMoney());
    }
}
