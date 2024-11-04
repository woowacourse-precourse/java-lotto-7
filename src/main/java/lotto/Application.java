package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputMoneyToBuy inputMoneyToBuy = new InputMoneyToBuy();
        int moneyAmount = inputMoneyToBuy.inputMoneyToBuy();

        CalculateLottoAmount calculateLottoAmount = new CalculateLottoAmount(moneyAmount);
        int numberOfLottos = calculateLottoAmount.getLottoAmount();

        PickRandomLotto pickRandomLotto = new PickRandomLotto(numberOfLottos);
        List<List<Integer>> lottoNumbers = pickRandomLotto.getGeneratedLottos();

        OutputLottoNumber outputLottoNumber = new OutputLottoNumber();
        outputLottoNumber.printLottoNumbers(lottoNumbers);

        InputLottoNumber inputLottoNumber = new InputLottoNumber();
        List<Integer> winningNumbers = inputLottoNumber.inputLottoNumber();

        InputBonusNumber inputBonusNumber = new InputBonusNumber(winningNumbers);
        int bonusNumber = inputBonusNumber.getBonusNumber();


        CompareLottoWinning compareLottoWinning = new CompareLottoWinning(winningNumbers, bonusNumber);
        compareLottoWinning.calculateResults(lottoNumbers);

        OutputWinningAmount outputWinningAmount = new OutputWinningAmount();
        outputWinningAmount.printWinningStatistics(compareLottoWinning.getMatchCounts());

        int totalEarnings = calculateTotalEarnings(compareLottoWinning.getMatchCounts());
        CalculateEarningRate calculateEarningRate = new CalculateEarningRate();
        double earningRate = calculateEarningRate.calculate(totalEarnings, moneyAmount);
        calculateEarningRate.printEarningRate(earningRate);
    }
    private static int calculateTotalEarnings(int[] matchCounts) {
        int totalEarnings = 0;
        totalEarnings += matchCounts[3] * 5000;           // 3개 일치
        totalEarnings += matchCounts[4] * 50000;          // 4개 일치
        totalEarnings += matchCounts[5] * 1500000;        // 5개 일치
        totalEarnings += matchCounts[2] * 30000000;       // 5개 + 보너스 일치
        totalEarnings += matchCounts[1] * 2000000000;     // 6개 일치
        return totalEarnings;
    }
}

