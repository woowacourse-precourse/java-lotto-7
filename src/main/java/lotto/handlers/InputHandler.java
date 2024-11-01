package lotto.handlers;

import camp.nextstep.edu.missionutils.Console;
import lotto.ui.InputView;
import lotto.validators.BonusNumberValidator;
import lotto.validators.LottoNumberValidator;
import lotto.validators.PurchaseAmountValidator;

public class InputHandler {
    private final InputView inputView;
    private final LottoHandler lottoHandler;
    private String lottoNumbers;

    public InputHandler(InputView inputView, LottoHandler lottoHandler) {
        this.inputView = inputView;
        this.lottoHandler = lottoHandler;
    }

    public String handlePurchaseAmountInput() {
        PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();
        String input = "";

        inputView.printPurchasePrompt();
        do {
            input = Console.readLine().strip();
        } while (!purchaseAmountValidator.isValid(input));

        return input;
    }

    public String handleLottoNumberInput() {
        LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();
        String input = "";

        inputView.printLottoNumberPrompt();
        do {
            input = Console.readLine().strip();
        } while (!lottoNumberValidator.isValid(input));

        this.lottoNumbers = input;
        return input;
    }

    public String handleBonusNumberInput() {
        BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
        String input = "";

        inputView.printBonusNumberPrompt();
        do {
            input = Console.readLine().strip();
        } while (!bonusNumberValidator.isValid(input + ":" + this.lottoNumbers));

        return input;
    }
}
