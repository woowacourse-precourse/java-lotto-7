package lotto.model;

import java.math.BigInteger;
import java.util.List;

public class Winning {
    Lotto winNumbers;
    BigInteger bonusNumber;

    public Winning(List<Integer> winNumbers, BigInteger bonusNumber) {
        this.winNumbers = new Lotto(winNumbers);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinNumbers() { return winNumbers; }
    public BigInteger getBonusNumber() { return bonusNumber; }
}
