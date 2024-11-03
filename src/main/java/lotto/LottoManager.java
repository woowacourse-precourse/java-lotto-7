package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private List<Lotto> lottos;
    private List<Integer> winningLotto;
    private int BonusNumber;

    public LottoManager() {
        this.lottos=new ArrayList<>();
    }

    void setWinningLotto(List<Integer> winningLotto) {
        this.winningLotto=winningLotto;
    }

    public void setBonus(int num) {
        this.BonusNumber=num;
    }

    public void makeLotto(List<Integer> lottoNums) {
        lottos.add(new Lotto(lottoNums));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

//    public int calculatePrices() {
//
//    }
}
