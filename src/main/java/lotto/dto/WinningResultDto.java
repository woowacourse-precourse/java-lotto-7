package lotto.dto;

import java.math.BigDecimal;
import java.util.Map;
import lotto.domain.Prize;

public record WinningResultDto(Map<Prize, Integer> rankCounts, BigDecimal profitRate) {

}
