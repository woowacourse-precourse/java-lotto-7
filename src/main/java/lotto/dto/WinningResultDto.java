package lotto.dto;

import lotto.model.result.WinningStatistics;
import lotto.util.ResultFormatter;

public record WinningResultDto(WinningStatistics statistics) {
}