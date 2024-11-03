package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.LottoWinningTier;
import lotto.domain.LottoWinningTierManager;
import lotto.service.LottoService;
import lotto.service.Validate;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.RequestMessage;
import lotto.view.ResultMessage;
import java.util.List;
import java.util.Map;

public class LottoController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final LottoService lottoService = new LottoService();
    private final Validate validate = new Validate();
    private List<Lotto> purchaseLottoNumbers;
    private LottoWinningNumbers lottoWinningNumbers;
    private LottoWinningTierManager lottoWinningTierManager;

    public void setPurchaseLottoNumbers () {
        while (true) {
            try {
                outputView.printMessage(RequestMessage.ENTER_PURCHASE_AMOUNT.getMessage());
                String purchaseAmount = inputView.readLine();
                purchaseLottoNumbers = lottoService.purchaseLotto(
                        validate.validatePurchaseAmount(purchaseAmount));
                break;
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    public void setWinningNumbers () {
        List<Integer> winningNumbers = initializeWinningNumbers();
        lottoWinningNumbers = new LottoWinningNumbers(
                winningNumbers,
                initializeBonusNumber(winningNumbers));
    }
    private List<Integer> initializeWinningNumbers () {
        while (true) {
            try {
                outputView.printMessage(RequestMessage.ENTER_WINNING_NUMBERS.getMessage());
                String winningNumbersInput = inputView.readLine();
                return validate.validateWinningNumbers(winningNumbersInput);
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }
    private int initializeBonusNumber (List<Integer> winningNumbers) {
        while (true) {
            try {
                outputView.printMessage(RequestMessage.ENTER_BONUS_NUMBER.getMessage());
                String bonusNumberInput = inputView.readLine();
                return validate.validateBonusNumber(bonusNumberInput, winningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    public void checkWinningNumbers () {
        lottoWinningTierManager = new LottoWinningTierManager();
        lottoService.checkWinningStatus(lottoWinningTierManager, purchaseLottoNumbers, lottoWinningNumbers);
    }
}
