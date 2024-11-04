package lotto.dto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoBundleDTO {
    private final List<Lotto> lottos;

    private LottoBundleDTO(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static LottoBundleDTO from(List<Lotto> lottos) {
        return new LottoBundleDTO(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
