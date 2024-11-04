package lotto.application.dto.response;

import lotto.domain.rank.RankResult;
import lotto.domain.rank.vo.RevenueRate;

public record ManageLottoResponse(RankResult rankResult, RevenueRate revenueRate) implements Response {
}
