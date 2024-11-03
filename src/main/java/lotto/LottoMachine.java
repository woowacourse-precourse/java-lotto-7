package lotto;

import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    public void run() {
        int purchaseCount = getPurchaseCountFromUser();
        List<Lotto> lottos = Lotto.generateLottos(purchaseCount);
        OutputView.printLottos(lottos);
        LottoWinningNumber winningNumber = getWinningNumberFromUser();
        LottoResultCounter resultCounter = winningNumber.countMatchingNumbers(lottos);
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
        return amount / LOTTO_PRICE;
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
