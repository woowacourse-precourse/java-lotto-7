package lotto.service;

import lotto.constant.Rank;

import java.util.List;

public class CalculatingWinningMoneyService {
    private int totalWinningMoney = 0;
    private double profitAbility;

    public void calculateTotalMoney(List<Integer> winningPrize,int five_bonus,int totalPurchaseMoney) {
        Rank[] values = Rank.values();
        // 2등  빼고 등수에 맞게 일단 돈을주고
        for (Rank value : values) {
            if (value!=Rank.SECOND){
                totalWinningMoney+= (value.winningPrize()*winningPrize.get(value.correctNumber()));
            }
        }
        // 2등만 따로줌
        totalWinningMoney+=five_bonus*(Rank.SECOND.winningPrize());
        profitAbility=(double) (totalWinningMoney)/totalPurchaseMoney;
        profitAbility*=100;
    }

    public int getTotalWinningMoney() {
        return totalWinningMoney;
    }

    public double getProfitAbility() {
        return profitAbility;
    }
}
