package lotto.dto;

import java.util.List;
import lotto.model.Lotto;

public record BuyLottosDTO(List<BuyLottoDTO> buyLottos) {
    public static BuyLottosDTO from(List<Lotto> lottos) {
        List<BuyLottoDTO> buyLottoDTOS = lottos.stream().map(lotto -> new BuyLottoDTO(lotto.getNumbers())).toList();
        return new BuyLottosDTO(buyLottoDTOS);
    }
}
