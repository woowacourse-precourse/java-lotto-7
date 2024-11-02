package lotto.domain;

import lotto.Lotto;

import java.math.BigInteger;

public class IssueRandomLotto {
    public static LottoPool makeRandomLotto(BigInteger numberOfLottos, LottoPool lottoPool) {
        for(BigInteger i = BigInteger.ZERO;!i.equals(numberOfLottos); i= i.add(BigInteger.ONE)) {
            lottoPool.addToDrawnLottos(new Lotto(new DrawNumber().draw()));
        }
        return lottoPool;
    }
}
