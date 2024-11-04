package lotto.global.dto.response;

import java.util.List;
import java.util.UUID;
import lotto.back.lotto.domain.Lottos;

public record PurchasedLottoResponseDTOs(UUID uuid, List<LottoResponseDTO> purchasedLottos) {

    public static PurchasedLottoResponseDTOs from(Lottos lottos) {
        return new PurchasedLottoResponseDTOs(
                lottos.getUuid(),
                lottos.getLottos().stream()
                        .map(LottoResponseDTO::from)
                        .toList()
        );
    }
}
