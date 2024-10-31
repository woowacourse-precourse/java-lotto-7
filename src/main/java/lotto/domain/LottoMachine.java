package lotto.domain;

import lotto.domain.factory.LottoFactory;

public class LottoMachine {

    private LottoFactory lottoFactory;
    private Lottos lottos;

    public LottoMachine() {
    }

    public void setLottoFactory(LottoFactory lottoFactory){
        this.lottoFactory = lottoFactory;
    }

    public void buyNumberOfLottos(int amount){
        lottos = new Lottos(amount,lottoFactory);
    }

}
