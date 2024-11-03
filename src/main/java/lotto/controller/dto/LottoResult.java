package lotto.controller.dto;

import java.util.List;
import lotto.model.enums.Rank;

public record LottoResult(
        List<Rank> ranks
) {
    public LottoResult(List<Rank> ranks) {
        this.ranks = ranks;
    }
}
