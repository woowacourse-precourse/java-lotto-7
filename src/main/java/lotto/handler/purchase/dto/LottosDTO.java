package lotto.handler.purchase.dto;

import java.util.List;
import lotto.handler.purchase.process.Lotto;

public class LottosDTO {
    private List<Lotto> lottos;

    private LottosDTO(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottosDTO create(List<Lotto> lottos) {
        return new LottosDTO(lottos);
    }
}
