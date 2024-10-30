package lotto.domain.player;

public class Player {

    private int lottoCount;

    public Player() {
        this.lottoCount = 0;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public void updateLottoCount(int lottoCount) {
        this.lottoCount = lottoCount;
    }
}
