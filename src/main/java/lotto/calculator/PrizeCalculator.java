package lotto.calculator;

import lotto.RankPrice;
import lotto.application.Calculator;
import lotto.domain.PrizeNumber;

public class PrizeCalculator implements Calculator {

    @Override
    public int calculateTotalPrize(PrizeNumber prizeNumber) {
        int firstPrize = calculatePrize(prizeNumber.getFirstPrizeLottoNumber(), RankPrice.FIRST.getPrice());
        int secondPrize = calculatePrize(prizeNumber.getSecondPrizeLottoNumber(), RankPrice.SECOND.getPrice());
        int thirdPrize = calculatePrize(prizeNumber.getThirdPrizeLottoNumber(), RankPrice.THIRD.getPrice());
        int fourthPrize = calculatePrize(prizeNumber.getFourthPrizeLottoNumber(), RankPrice.FOURTH.getPrice());
        int fifthPrize = calculatePrize(prizeNumber.getFifthPrizeLottoNumber(), RankPrice.FIFTH.getPrice());
        return firstPrize + secondPrize + thirdPrize + fourthPrize + fifthPrize;
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

    private int calculatePrize(int number, int money) {
        return number * money;
    }
}
