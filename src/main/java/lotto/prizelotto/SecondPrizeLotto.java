package lotto.prizelotto;

import lotto.RankPrice;

public class SecondPrizeLotto implements PrizeLotto {

    private int count;

    @Override
    public void of() {
        count++;
    }

    @Override
    public int calculateMoney() {
        return count * RankPrice.SECOND.getPrice();
    }
}
