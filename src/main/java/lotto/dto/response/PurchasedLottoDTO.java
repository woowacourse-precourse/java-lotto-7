package lotto.dto.response;

import java.util.List;
import lotto.domain.Lotto;

public record PurchasedLottoDTO(
        List<Integer> numbers
) {
    public static PurchasedLottoDTO from(Lotto purchasedLotto) {
        return new PurchasedLottoDTO(purchasedLotto.getNumbersAsUnmodifiableList());
    }
}
