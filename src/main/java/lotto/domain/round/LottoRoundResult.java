package lotto.domain.round;

import java.util.List;
import java.util.Objects;
import lotto.config.validation.FieldValidation;
import lotto.config.validation.annotation.Length;
import lotto.domain.core.LottoRank;

public class LottoRoundResult extends FieldValidation {

    @Length(min = 1)
    private final List<LottoRank> ranks;

    public LottoRoundResult(List<LottoRank> ranks) {
        this.ranks = ranks;

        super.valid();
    }

    public int size() {
        return ranks.size();
    }

    public int getRankCount(LottoRank rank) {
        return (int) ranks.stream()
                .filter(Objects::nonNull)
                .filter(it -> it.equals(rank))
                .count();
    }
}
