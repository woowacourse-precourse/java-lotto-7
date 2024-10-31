package lotto;

import java.math.BigDecimal;
import java.util.Map.Entry;

public record WinningRecipe(
        int rank,
        BigDecimal price,
        int matchCount
) {
    public static WinningRecipe of(final Entry<LottoRank, Integer> entry) {
        final LottoRank lottoRank = entry.getKey();
        final Integer matchCount = entry.getValue();
        return new WinningRecipe(
                lottoRank.getRank(),
                lottoRank.getPrice(),
                matchCount
        );
    }
}
