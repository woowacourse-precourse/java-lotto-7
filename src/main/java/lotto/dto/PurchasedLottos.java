package lotto.dto;

import java.util.List;
import lotto.domain.Lotto;

public record PurchasedLottos(
        List<String> lottos
) {
    public static PurchasedLottos from(List<Lotto> lottos) {
        return new PurchasedLottos(lottos.stream()
                .map(Lotto::toString)
                .toList());
    }
}
