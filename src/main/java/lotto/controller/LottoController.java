package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.service.LottoServiceFacade;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoServiceFacade lottoServiceFacade;

    public LottoController(InputView inputView, OutputView outputView, LottoServiceFacade lottoServiceFacade) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoServiceFacade = lottoServiceFacade;
    }

    public void run() {
        int purchaseAmount = retryUntilValid(inputView::readPurchaseAmount);
        purchaseLotto(purchaseAmount);

        setWinningNumbers();
        lottoServiceFacade.createWinningLotto(getValidatedBonusNumber());


        lottoServiceFacade.calculateResults(purchaseAmount);
        outputView.printWinningStatistics(lottoServiceFacade.getWinningStatistics());
        outputView.printTotalProfitRate(lottoServiceFacade.getProfitRate());
    }

    private int getValidatedBonusNumber() {
        return retryUntilValid(() -> {
            int bonusNumber = retryUntilValid(inputView::readBonusNumber);
            lottoServiceFacade.validateBonusNumber(bonusNumber);
            return bonusNumber;
        } );
    }

    private void purchaseLotto(int purchaseAmount) {
        lottoServiceFacade.purchaseLotto(purchaseAmount);
        outputView.printPurchasedLottos(lottoServiceFacade.getPurchasedLottos());
    }

    private void setWinningNumbers() {
        retryUntilValid(() -> {
            List<Integer> numbers = inputView.readWinningNumbers();
            lottoServiceFacade.setWinningNumbers(numbers);
            return numbers;
        });
    }

    private <T> T retryUntilValid(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
