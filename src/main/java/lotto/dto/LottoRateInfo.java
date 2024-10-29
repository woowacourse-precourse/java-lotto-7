package lotto.dto;

import lotto.model.LottoInfo;

import java.util.EnumMap;

public record LottoRateInfo(
        EnumMap<LottoInfo, Integer> winningLottoCount,
        double returnRate
) {
}
