package lotto.view.output;

import lotto.enums.LottoPrize;
import lotto.enums.OutputMessage;

import java.util.HashMap;

public class LottoResultOutputView implements OutputView {
    private final LottoPrize[] lottoPrizes = {
            LottoPrize.FIFTH_PRIZE,
            LottoPrize.FOURTH_PRIZE,
            LottoPrize.THIRD_PRIZE,
            LottoPrize.SECOND_PRIZE,
            LottoPrize.FIRST_PRIZE
    };

    private final HashMap<LottoPrize, Integer> winningHistory;
    private final double rateOfReturn;

    public LottoResultOutputView(HashMap<LottoPrize, Integer> winningHistory, double rateOfReturn){
        this.winningHistory = winningHistory;
        this.rateOfReturn = rateOfReturn;
    }

    @Override
    public void print(){
        printWinningHistory();
        printRateOfReturn();
    }

    private void printWinningHistory(){
        System.out.println(OutputMessage.WINNING_HISTORY_TITLE.getMessage());

        for(LottoPrize lottoPrize: lottoPrizes){
            int correctCount = lottoPrize.getCorrectCount();
            int prizeMoney = lottoPrize.getPrizeMoney();
            int winningCount = winningHistory.getOrDefault(lottoPrize, 0);

            System.out.printf(getHistoryMessage(lottoPrize), correctCount, prizeMoney, winningCount);
        }
    }

    private void printRateOfReturn(){
        System.out.printf(OutputMessage.TOTAL_RATE_OF_RETURN.getMessage(), rateOfReturn);
    }

    private String getHistoryMessage(LottoPrize lottoPrize){
        if(lottoPrize == LottoPrize.SECOND_PRIZE){
            return OutputMessage.SECOND_PRIZE_WINNING_HISTORY.getMessage();
        }

        return OutputMessage.WINNING_HISTORY.getMessage();
    }
}
