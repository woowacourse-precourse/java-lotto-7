package lotto.application.dto.response;

import java.util.Map;
import lotto.domain.lotto.vo.LottoPrize;

public record EvaluateWinningLottoResponse(
    Map<LottoPrize, Integer> winningResult,
    double earningRate
) implements Response {}
