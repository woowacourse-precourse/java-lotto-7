package lotto.dto;

import java.util.List;
import lotto.domain.Lotto;

public record BuyLottos(
        List<Lotto> numbers
) {
    public static BuyLottos of(List<Lotto> lottos) {
        return new BuyLottos(lottos);
    }
}
