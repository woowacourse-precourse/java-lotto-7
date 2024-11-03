package lotto.dto;

import java.math.BigDecimal;
import java.util.Map;
import lotto.domain.Rank;

public record WinningResultDto(Map<Rank, Integer> rankCounts, BigDecimal profitRate) {

}
