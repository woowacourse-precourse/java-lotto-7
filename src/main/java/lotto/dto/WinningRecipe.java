package lotto.dto;

import java.math.BigDecimal;
import java.util.Map.Entry;
import lotto.domain.winning.LottoRank;

public record WinningRecipe(
        int rank,
        int matchCount,
        BigDecimal price,
        int matchQuantity
) {
    public static WinningRecipe of(final Entry<LottoRank, Integer> entry) {
        final LottoRank lottoRank = entry.getKey();
        final Integer matchQuantity = entry.getValue();
        return new WinningRecipe(
                lottoRank.getRank(),
                lottoRank.getMatchCount(),
                lottoRank.getPrice(),
                matchQuantity
        );
    }
}
