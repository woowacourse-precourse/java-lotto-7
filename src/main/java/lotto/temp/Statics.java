package lotto.temp;

import lotto.model.Lotto;

public class Statics {
    public boolean checkBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public float calculateProfit(int money, int totalPrize){
        float profit = ((float)totalPrize / money) * 100;
        return Math.round(profit * 10) / 10.0f;
    }

}
