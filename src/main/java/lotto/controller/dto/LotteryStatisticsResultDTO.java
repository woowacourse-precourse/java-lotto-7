package lotto.controller.dto;

import java.util.List;
import lotto.domain.statistics.Statistics;

public record LotteryStatisticsResultDTO(List<Statistics> statistics, Double returnRate) {
}
