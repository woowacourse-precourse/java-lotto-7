package lotto.domain;

import lotto.Lotto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class LottoPool {
    private List<Lotto> lottosDrawn = new ArrayList<Lotto>();

    public LottoPool makeRandomLotto(BigInteger numberOfLottos) {
        for(BigInteger i = BigInteger.ZERO;!i.equals(numberOfLottos); i= i.add(BigInteger.ONE)) {
            addToDrawnLottos(new Lotto(new DrawNumber().draw()));
        }
        return this;
    }

    public List<Lotto> getLottosDrawn(){
        return lottosDrawn;
    }

    public void addToDrawnLottos(Lotto lotto){
        lottosDrawn.add(lotto);
    }
}
