package lotto.controller;

import lotto.model.Lotto;
import lotto.model.PurchasedLotto;
import lotto.util.ErrorMessage;
import lotto.util.InputValidator;
import lotto.util.Separator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private static final int LOTTO_PRICE = 1000;

    private final InputValidator inputValidator;

    public LottoController(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        PurchasedLotto purchasedLotto = new PurchasedLotto(purchaseAmount/LOTTO_PRICE);
        OutputView.printPurchasedLottos(purchasedLotto);

        Lotto lotto = createWinningLotto();
        int bonusNumber = getBonusNumber();
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                int purchaseAmount = parseInt(InputView.getPurchaseAmount());
                inputValidator.validatePurchaseAmount(purchaseAmount, LOTTO_PRICE);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto createWinningLotto() {
        while (true) {
            try {
                List<Integer> winningNumbers = Separator.splitWithCommaToInteger(InputView.getWinningNumbers());
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBonusNumber() {
        while (true) {
            try {
                int bonusNumber = parseInt(InputView.getBonusNumber());
                inputValidator.validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_TYPE_INT.getMessage());
        }
    }

}
