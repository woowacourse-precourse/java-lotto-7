package lotto.dto;

import java.util.List;

public record LottoWinStatisticDTO(
        List<Integer> winLottoCount,
        Float profitRate
) {}