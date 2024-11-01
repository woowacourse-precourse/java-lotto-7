package lotto.handlers;

import camp.nextstep.edu.missionutils.Console;
import lotto.ui.InputView;
import lotto.validators.BonusNumberValidator;
import lotto.validators.LottoNumberValidator;
import lotto.validators.PurchaseAmountValidator;

public class InputHandler {
    private final InputView inputView;
    private String lottoNumbers;

    public InputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    public void handlePurchaseAmountInput(LottoHandler lottoHandler,  ResultHandler resultHandler) {
        PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();
        String input;

        inputView.printPurchasePrompt();
        do {
            input = Console.readLine().strip();
        } while (!purchaseAmountValidator.isValid(input));

        int purchaseAmount = Integer.parseInt(input);
        lottoHandler.generateTickets(purchaseAmount);
        resultHandler.setPurchaseAmount(purchaseAmount);
    }

    public void handleLottoNumberInput() {
        LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();
        String input;

        inputView.printLottoNumberPrompt();
        do {
            input = Console.readLine().strip();
        } while (!lottoNumberValidator.isValid(input));

        this.lottoNumbers = input;
    }

    public void handleBonusNumberInput(ResultHandler resultHandler) {
        BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
        String input;

        inputView.printBonusNumberPrompt();
        do {
            input = Console.readLine().strip();
        } while (!bonusNumberValidator.isValid(input + ":" + this.lottoNumbers));

        resultHandler.setWinningTicket(this.lottoNumbers, input);
    }
}
