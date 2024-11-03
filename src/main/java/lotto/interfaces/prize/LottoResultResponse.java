package lotto.interfaces.prize;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.prize.LottoPrize;
import lotto.domain.prize.LottoResult;
import lotto.domain.money.Revenue;

public record LottoResultResponse(
        List<LottoPrizeResponse> lottoPrizes,
        double returns
) {
    public static LottoResultResponse of(LottoResult lottoResult, Revenue revenue) {
        List<LottoPrizeResponse> prizeResponses = lottoResult.getLottoResult().entrySet().stream()
                .filter(entry -> entry.getKey() != LottoPrize.NONE)
                .map(entry -> LottoPrizeResponse.of(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        return new LottoResultResponse(prizeResponses, revenue.getReturns());
    }
}
