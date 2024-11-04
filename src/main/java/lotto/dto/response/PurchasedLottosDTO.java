package lotto.dto.response;

import java.util.List;
import lotto.domain.PurchasedLottos;

public record PurchasedLottosDTO(
        List<PurchasedLottoDTO> purchasedLottoDTOs
) {
    public static PurchasedLottosDTO from(PurchasedLottos purchasedLottos) {
        return new PurchasedLottosDTO(
                purchasedLottos.getLottosAsUnmodifiableList()
                        .stream()
                        .map(PurchasedLottoDTO::from)
                        .toList()
        );
    }
}
