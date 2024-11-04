package lotto.dto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import lotto.model.Ranking;
import lotto.model.WinningStatistics;

public record ResultDto(
        List<ResultItemDto> resultItems,
        BigDecimal roi
) {
    public static ResultDto from(WinningStatistics statistics) {
        List<ResultItemDto> resultItems = Arrays.stream(Ranking.values())
                .sorted(Comparator.reverseOrder())
                .filter(ranking -> ranking != Ranking.NONE)
                .map(ranking -> new ResultItemDto(ranking, statistics.getCount(ranking)))
                .toList();
        return new ResultDto(resultItems, statistics.getRoi());
    }
}
