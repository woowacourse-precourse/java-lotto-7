package lotto.domain.player;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int lottoCount;
    private List<PlayerLotto> lottos;

    public Player() {
        this.lottoCount = 0;
        this.lottos = new ArrayList<>();
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<PlayerLotto> getLottos() {
        return lottos;
    }

    public void updateLottoCount(int lottoCount) {
        this.lottoCount = lottoCount;
    }
}
