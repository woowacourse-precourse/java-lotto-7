package lotto.dto;

import lotto.domain.Prize;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public record WinningSummaryResponse(List<MatchingCountResponse> matchingCountResponses) {
    public static WinningSummaryResponse from(Map<Prize, Integer> winningSummary) {
        List<MatchingCountResponse> matchingCountResponses = Arrays.stream(Prize.values())
                .map(prize -> new MatchingCountResponse(prize, winningSummary.get(prize)))
                .toList();

        return new WinningSummaryResponse(matchingCountResponses);
    }

    public record MatchingCountResponse(
            int matchingNumberCount,
            int prizeMoney,
            String bonusNumberStatus,
            int winningCount
    ) {
        public MatchingCountResponse(Prize prize, int winningCount) {
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
}


