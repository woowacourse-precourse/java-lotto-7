package lotto.domain;

import java.util.List;

import static lotto.util.constant.LottoConstants.*;

public class LottoCollection {

    private final long purchaseMoney;
    private int bonusNumber;
    private Lotto winnerLotto;
    private List<Lotto> lotto;

    public LottoCollection(long purchaseMoney) {
        this.lotto = null;
        this.winnerLotto = null;
        this.purchaseMoney = purchaseMoney;
        this.bonusNumber = 0;
    }

    public void setLotto(List<Lotto> lotto) {
        if (this.lotto == null) {
            this.lotto = lotto;
        }
    }

    public void setWinnerLottoAndBonusNumber(Lotto winnerLotto, int bonusNumber) {
        if (this.winnerLotto == null) {
            setWinnerLotto(winnerLotto);
            setBonusNumber(bonusNumber);
        }
    }

    private void setBonusNumber(int bonusNumber){
        this.bonusNumber = bonusNumber;
    }

    private void setWinnerLotto(Lotto winnerLotto){
        this.winnerLotto = winnerLotto;
    }


    public int getNumOfLotto(){
        return (int)(purchaseMoney / LOTTO_BASE_UNIT);
    }

    public List<Lotto> getLotto(){
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public long getPurchaseMoney() {
        return purchaseMoney;
    }

    public Lotto getWinnerLotto() {
        return winnerLotto;
    }
}
