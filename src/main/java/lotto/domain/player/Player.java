package lotto.domain.player;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int lottoCount;
    private List<PlayerLotto> lottos;
    private PlayerResult playerResult;

    public Player() {
        this.lottoCount = 0;
        this.lottos = new ArrayList<>();
        this.playerResult = new PlayerResult();
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<PlayerLotto> getLottos() {
        return lottos;
    }

    public PlayerResult getPlayerResult() {
        return playerResult;
    }

    public void updateLottoCount(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public void addLotto(PlayerLotto lotto) {
        lottos.add(lotto);
    }
}
