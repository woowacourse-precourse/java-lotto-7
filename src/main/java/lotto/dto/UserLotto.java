package lotto.dto;

import java.util.List;
import lotto.domain.Lotto;

public class UserLotto {

    private final int lottoCount;
    private final List<Lotto> lottos;

    public UserLotto(int lottoCount, List<Lotto> lottos) {
        this.lottoCount = lottoCount;
        this.lottos = lottos;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
