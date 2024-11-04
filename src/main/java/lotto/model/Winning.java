package lotto.model;

import java.math.BigInteger;
import java.util.List;

public class Winning {
    List<BigInteger> winNumbers;
    BigInteger bonusNumber;

    public Winning(List<BigInteger> winNumbers, BigInteger bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<BigInteger> getWinNumbers() { return winNumbers; }
    public BigInteger getBonusNumber() { return bonusNumber; }
}
