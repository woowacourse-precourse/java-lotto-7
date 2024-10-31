package lotto.service;

import lotto.Lotto;

import java.math.BigInteger;
import java.util.List;

public class LottoConverter {
    public List<Integer> LottoIntoNumber(Lotto lotto) {
        return lotto.getNumbers();
    }

    public BigInteger MoneyToLotto(BigInteger money) {
        if(!money.mod(BigInteger.valueOf(1000)).equals(BigInteger.ZERO)) throw new IllegalArgumentException("[ERROR] 로또는 1000원 단위로 살 수 있습니다.");
        return money.divide(BigInteger.valueOf(1000));
    }
}
