package lotto.domain;

import java.util.List;

public class LottoWallet {
    private final List<Lotto> lottos;
    private int MatchThree = 0;
    private int MatchFour = 0;
    private int MatchFive = 0;
    private int MatchFiveAndBonus = 0;
    private int MatchSix = 0;

    public LottoWallet(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
    public int getLottosCount() {
        return lottos.size();
    }
}
