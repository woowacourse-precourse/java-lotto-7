package lotto;

import java.math.BigDecimal;

public record WinningRecipe(
        int rank,
        BigDecimal price,
        int matchCount
) {
    public WinningRecipe of(final LottoRank lottoRank, final int matchCount) {
        return new WinningRecipe(
                lottoRank.getRank(),
                lottoRank.getPrice(),
                matchCount
        );
    }
}
