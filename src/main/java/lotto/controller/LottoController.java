package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoWinningNumbers;
import lotto.service.LottoService;
import lotto.service.Validate;
import lotto.view.*;

import java.util.List;

public class LottoController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final LottoService lottoService = new LottoService();
    private final Validate validate = new Validate();
    private List<Lotto> purchaseLottoNumbers;
    private LottoWinningNumbers lottoWinningNumbers;

    public void setPurchaseLottoNumbers () {
        outputView.printMessage(RequestMessage.ENTER_PURCHASE_AMOUNT.getMessage());
        String purchaseAmount = inputView.readLine();
        purchaseLottoNumbers = lottoService.purchaseLotto(
                validate.validatePurchaseAmount(purchaseAmount));
    }

    public void setWinningNumbers () {
        outputView.printMessage(RequestMessage.ENTER_WINNING_NUMBERS.getMessage());
        String winningNumbersInput = inputView.readLine();
        outputView.printMessage(RequestMessage.ENTER_BONUS_NUMBER.getMessage());
        String bonusNumberInput = inputView.readLine();
        lottoWinningNumbers = new LottoWinningNumbers(
                validate.validateWinningNumbers(winningNumbersInput),
                validate.validateBonusNumber(bonusNumberInput));
    }
}
