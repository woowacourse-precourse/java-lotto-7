package lotto.dto;

import java.util.List;

public record WinningStatisticsDto(
        List<WinningCountDto> WinningCountDtos,
        double returnRate
) {
    public static WinningStatisticsDto of(List<WinningCountDto> WinningCountDtos, double returnRate) {
        return new WinningStatisticsDto(WinningCountDtos, returnRate);
    }

    public record WinningCountDto(
            int matchCount,
            boolean hasBonusNumber,
            long prize,
            int count
    ) {
        public static WinningCountDto of(int matchCount, boolean hasBonusNumber, long prize, int count) {
            return new WinningCountDto(matchCount, hasBonusNumber, prize, count);
        }
    }
}
