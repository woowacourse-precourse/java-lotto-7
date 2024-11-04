package lotto.dto;

import lotto.model.LottoResult;

public record LottoResultResponse(LottoResult result, double profitRate) {
}
