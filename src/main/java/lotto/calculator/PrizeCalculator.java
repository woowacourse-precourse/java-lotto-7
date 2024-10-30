package lotto.calculator;

import lotto.RankPrice;
import lotto.application.Calculator;
import lotto.domain.PrizeNumber;

public class PrizeCalculator implements Calculator {

    @Override
    public int calculateTotalPrize(PrizeNumber prizeNumber) {
        int first = multiple(prizeNumber.getFirstPrizeLottoNumber(), RankPrice.FIRST.getPrice());
        int second = multiple(prizeNumber.getSecondPrizeLottoNumber(), RankPrice.SECOND.getPrice());
        int third = multiple(prizeNumber.getThirdPrizeLottoNumber(), RankPrice.THIRD.getPrice());
        int fourth = multiple(prizeNumber.getFourthPrizeLottoNumber(), RankPrice.FOURTH.getPrice());
        int fifth = multiple(prizeNumber.getFifthPrizeLottoNumber(), RankPrice.FIFTH.getPrice());
        return first + second + third + fourth + fifth;
    }

    @Override
    public double calculateProfit(int totalPrize, int purchasePrice) {
        System.out.println("totalPrize = " + totalPrize);
        double result = ((double) (totalPrize - purchasePrice) / purchasePrice) * 100;
        if (result < 0) {
            return 100 + result;
        }
        return result;
    }

    private int multiple(int number, int money) {
        return number * money;
    }
}
