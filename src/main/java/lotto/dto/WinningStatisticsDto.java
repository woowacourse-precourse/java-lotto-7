package lotto.dto;

import java.util.List;

public record WinningStatisticsDto(
        List<WinningCountDto> WinningCountDts,
        long totalPrizeAmount,
        double returnRate,
        int totalTicketCount
) {
    public record WinningCountDto(
            int matchCount,
            boolean hasBonusNumber,
            long prize,
            int count
    ) {
    }
}
