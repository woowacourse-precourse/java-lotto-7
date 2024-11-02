package lotto.io;

import lotto.util.ResultMessages;

public class ResultPrintHandler {
    public void printWinningStatics() {
        System.out.println(ResultMessages.WINNING_STATICS.getMessage());
        System.out.println(ResultMessages.DIVIDER.getMessage());
    }

    public void printFifthPrize(int fifthPrize) {
        System.out.println(ResultMessages.FIFTH_PRIZE.getMessage(fifthPrize));
    }

    public void printFourthPrize(int fourthPrize) {
        System.out.println(ResultMessages.FOURTH_PRIZE.getMessage(fourthPrize));
    }

    public void printThirdPrize(int thirdPrize) {
        System.out.println(ResultMessages.THIRD_PRIZE.getMessage(thirdPrize));
    }

    public void printSecondPrize(int secondPrize) {
        System.out.println(ResultMessages.SECOND_PRIZE.getMessage(secondPrize));
    }

    public void printFirstPrize(int firstPrize) {
        System.out.println(ResultMessages.FIRST_PRIZE.getMessage(firstPrize));
    }

    public void printProfitRate(float profitRate) {
        System.out.println(ResultMessages.TOTAL_PROFIT_RATE.getMessage(profitRate));
    }
}
