package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        InputView.requestAmount();
        int totalAmount = InputView.getAmount();
        List<Lotto> lotteries = LottoGenerator.generate(totalAmount);

        OutputView.printReceipt(new LottoReceipt(lotteries));

        InputView.requestWinningNumber();
        WinningNumber winningNumber = InputView.getWinningNumber();

        // output view
        // 당첨 통계
        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(winningNumber);
        Map<Rank, Integer> rankingResult = lottoResultCalculator.calculateRanking(lotteries);
        double rateOfReturn = lottoResultCalculator.calculateRateOfReturn(rankingResult, totalAmount);
        System.out.println("수익률: " + rateOfReturn);

    }
}
