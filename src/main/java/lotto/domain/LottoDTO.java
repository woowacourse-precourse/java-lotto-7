package lotto.domain;

import java.util.List;

public class LottoDTO {
    private List<Lotto> lottos;

    public LottoDTO(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}
