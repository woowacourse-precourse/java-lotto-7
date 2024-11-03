package lotto.interfaces;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.prize.LottoResult;
import lotto.domain.money.Revenue;

public record LottoResponse(
        List<LottoPrizeResponse> lottoPrizes,
        double returns
) {
    public static LottoResponse of(LottoResult lottoResult, Revenue revenue) {
        List<LottoPrizeResponse> prizeResponses = lottoResult.getLottoResult().entrySet().stream()
                .map(entry -> LottoPrizeResponse.of(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        return new LottoResponse(prizeResponses, revenue.getReturns());
    }
}
