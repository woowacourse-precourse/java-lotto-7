package lotto.application.service;

import lotto.application.dto.request.ManageLottoRequest;
import lotto.application.dto.response.ManageLottoResponse;
import lotto.application.port.inbound.ManageLottoUseCase;
import lotto.domain.rank.RankResult;
import lotto.domain.rank.vo.RevenueRate;

public class ManageLottoUseCaseImpl implements ManageLottoUseCase {
    @Override
    public ManageLottoResponse getResult(ManageLottoRequest request) {
        RankResult rankResult = RankResult.from(request.lottos(), request.winningLotto());
        final int revenue = rankResult.getRevenue();
        RevenueRate revenueRate = RevenueRate.of(revenue, request.cost().value());
        return new ManageLottoResponse(rankResult, revenueRate);
    }
}
