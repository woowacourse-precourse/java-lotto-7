package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputLottoNumber inputLottoNumber = new InputLottoNumber();
        List<Integer> winningNumbers = inputLottoNumber.inputLottoNumber();

        InputBonusNumber inputBonusNumber = new InputBonusNumber(winningNumbers);
        int bonusNumber = inputBonusNumber.getBonusNumber();

        PickRandomLotto pickRandomLotto = new PickRandomLotto(lottoAmount);
        List<List<Integer>> userLottos = pickRandomLotto.getLottos();

        // 3. 구매한 로또 번호 출력
        OutputLottoNumber outputLottoNumber = new OutputLottoNumber();
        outputLottoNumber.printLottoNumbers(userLottos);

        // 4. 당첨 번호와 비교하여 당첨 내역 계산
        CompareLottoWinning compareLottoWinning = new CompareLottoWinning(winningNumbers, bonusNumber);
        compareLottoWinning.calculateResults(userLottos);

        // 5. 당첨 내역 출력
        OutputWinningAmount outputWinningAmount = new OutputWinningAmount();
        outputWinningAmount.printWinningStatistics(compareLottoWinning.getMatchCounts());

        // 6. 수익률 계산 및 출력
        int totalEarnings = calculateTotalEarnings(compareLottoWinning.getMatchCounts());
        CalculateEarningRate calculateEarningRate = new CalculateEarningRate();
        double earningRate = calculateEarningRate.calculate(totalEarnings, purchaseAmount);

    }

}
}
