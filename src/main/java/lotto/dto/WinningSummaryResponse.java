package lotto.dto;

import lotto.domain.Prize;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public record WinningSummaryResponse(List<WinningDetailResponse> winningDetailResponse, double profitRate) {
    public static WinningSummaryResponse from(Map<Prize, Integer> winningSummary, double profitRate) {
        List<WinningDetailResponse> winningDetailResponse = Arrays.stream(Prize.values())
                .map(prize -> new WinningDetailResponse(prize, winningSummary.get(prize)))
                .toList();

        return new WinningSummaryResponse(winningDetailResponse, profitRate);
    }

    public record WinningDetailResponse(
            int matchingNumberCount,
            int prizeMoney,
            String bonusNumberStatus,
            int winningCount
    ) {
        public WinningDetailResponse(Prize prize, int winningCount) {
            this(
                    prize.getMatchingNumberCount(),
                    prize.getPrizeMoney(),
                    prize.getBonusNumberStatus().name(),
                    winningCount
            );
        }
    }
}
