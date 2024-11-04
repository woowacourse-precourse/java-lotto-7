package lotto.dto;

import lotto.domain.Prize;

public record PrizeResponse(
        int matchingNumberCount,
        int prizeMoney,
        String bonusNumberStatus,
        int winningCount
) {
    public PrizeResponse(Prize prize, int winningCount) {
        this(
                prize.getMatchingNumberCount(),
                prize.getPrizeMoney(),
                prize.getBonusNumberStatus().name(),
                winningCount
        );
    }

    public int getProfit() {
        return prizeMoney * winningCount;
    }
}
