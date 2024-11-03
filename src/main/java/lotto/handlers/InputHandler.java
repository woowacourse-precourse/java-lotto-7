package lotto.handlers;

import camp.nextstep.edu.missionutils.Console;
import lotto.models.Lotto;
import lotto.ui.InputView;
import lotto.validators.BonusNumberValidator;
import lotto.validators.PurchaseAmountValidator;

import java.util.stream.Stream;

public class InputHandler {
    private final InputView inputView;

    public InputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    private String getLottoNumberInput() {
        String input = "";
        boolean isValidInput = false;
        do {
            try {
                input = Console.readLine().strip();
                new Lotto(Stream.of(input.split(",")).map(Integer::parseInt).toList());
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!isValidInput);
        return input;
    }

    private String getBonusNumberInput(String winningNumbers) {
        BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
        String input = "";
        boolean isValidInput = false;
        do {
            try {
                input = Console.readLine().strip();
                isValidInput = bonusNumberValidator.isValid(winningNumbers, input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!isValidInput);
        return input;
    }

    public void handlePurchaseAmountInput(LottoHandler lottoHandler, ResultHandler resultHandler) {
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

    public void handleWinningTicketInput(ResultHandler resultHandler) {
        inputView.printLottoNumberPrompt();
        String winningNumbers = getLottoNumberInput();

        inputView.printBonusNumberPrompt();
        String bonusNumber = getBonusNumberInput(winningNumbers);

        resultHandler.setWinningTicket(winningNumbers, bonusNumber);
    }
}
