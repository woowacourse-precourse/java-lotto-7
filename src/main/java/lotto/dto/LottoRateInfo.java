package lotto.dto;

import lotto.model.Ranking;

import java.util.EnumMap;

public record LottoRateInfo(
        EnumMap<Ranking, Integer> winningLottoCount,
        double returnRate
) {
}
