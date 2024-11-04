package lotto.model;

import java.util.List;

public record LottoBought(
    List<LottoEntity> lottos
) {
    public static LottoBought map(
        List<LottoEntity> lottos
    ) {
        return new LottoBought(
            lottos
        );
    }
}
