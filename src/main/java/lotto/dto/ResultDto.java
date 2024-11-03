package lotto.dto;

import java.util.Map;

public record   ResultDto(Map<PrizeRankInfoDto, Integer> prizeRankCounts, float profitRatio) {
}
