package lotto;

import java.util.HashMap;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoCommittee;
import lotto.model.LottoMachine;
import lotto.model.Ranking;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        int purchaseAmount = inputPurchaseAmountRepeat();
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.purchaseLottos(purchaseAmount);
        OutputView.printPurchasedLottoCountAndNumber(lottos);

        LottoCommittee lottoCommittee = new LottoCommittee();
        inputWinningNumbersRepeat(lottoCommittee);
        inputBonusNumberRepeat(lottoCommittee);

        HashMap<Ranking, Integer> rankingCountMap = lottoCommittee.calculateRanking(lottos);
        OutputView.printWinningHistory(rankingCountMap);
        OutputView.printRateOfReturn(purchaseAmount, rankingCountMap);
    }

    private static int inputPurchaseAmountRepeat() {
        try {
            return InputView.inputPurchaseAmount();
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmountRepeat();
        }
    }

    private static List<Integer> inputWinningNumbersRepeat(LottoCommittee lottoCommittee) {
        try {
            List<Integer> winningNumbers = InputView.inputWinningNumber();
            lottoCommittee.insertWinningNumbers(winningNumbers);
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumbersRepeat(lottoCommittee);
        }
    }

    private static int inputBonusNumberRepeat(LottoCommittee lottoCommittee) {
        try {
            int bonusNumber = InputView.inputBonusNumber();
            lottoCommittee.insertBonusNumber(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumberRepeat(lottoCommittee);
        }
    }
}
