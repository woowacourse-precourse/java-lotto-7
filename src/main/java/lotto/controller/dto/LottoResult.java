package lotto.controller.dto;

import java.util.List;
import lotto.model.enums.Rank;

public record LottoResult(
        List<Rank> lottoResult
) {
    public LottoResult(List<Rank> lottoResult) {
        this.lottoResult = lottoResult;
    }
}
