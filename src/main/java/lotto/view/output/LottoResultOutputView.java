package lotto.view.output;

import lotto.enums.LottoPrize;
import lotto.view.output.OutputView;

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
        System.out.println("당첨 통계\n---");

        for(LottoPrize lottoPrize: lottoPrizes){
            int correctCount = lottoPrize.getCorrectCount();
            int prizeMoney = lottoPrize.getPrizeMoney();
            int winningCount = winningHistory.getOrDefault(lottoPrize, 0);

            System.out.printf("%d개 일치 (%,d원) - %d개\n", correctCount, prizeMoney, winningCount);
        }
    }

    private void printRateOfReturn(){
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }
}
