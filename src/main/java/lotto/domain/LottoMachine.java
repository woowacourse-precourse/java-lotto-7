package lotto.domain;

import java.util.List;

import lotto.common.Validator;
import lotto.io.InputView;
import lotto.io.OutputView;

public class LottoMachine {
    public void run() {
        int purchaseCount = getPurchaseCountFromUser();

        List<Lotto> lottos = Lotto.generateLottos(purchaseCount);
        OutputView.printLottos(lottos);

        LottoWinningNumber winningNumber = getWinningNumberFromUser();

        LottoResultCounter resultCounter = winningNumber.countMatchingNumbers(lottos);
        OutputView.printResult(resultCounter, purchaseCount * Lotto.LOTTO_PRICE);
    }

    private int getPurchaseCountFromUser() {
        while (true) {
            try {
                return tryGetPurchaseCountFromUser();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int tryGetPurchaseCountFromUser() {
        int amount = InputView.getAmountFromUser();
        Validator.checkValidPurchaseCount(amount);
        return amount / Lotto.LOTTO_PRICE;
    }

    private LottoWinningNumber getWinningNumberFromUser() {
        while (true) {
            try {
                return tryGetWinningNumberFromUser();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private LottoWinningNumber tryGetWinningNumberFromUser() {
        List<Integer> lottoNumbers = InputView.getLottoNumbersFromUser();
        int bonusNumber = InputView.getBonusNumberFromUser();
        return new LottoWinningNumber(lottoNumbers, bonusNumber);
    }
}
