package lotto.controller;

import static lotto.constant.ErrorMessage.INVALID_NUMERIC_INPUT;
import static lotto.constant.ErrorMessage.INVALID_PURCHASE_AMOUNT;
import static lotto.constant.ErrorMessage.PRINT_ERROR_MESSAGE;
import static lotto.constant.GameValue.DIVIDE_FOR_TICKET_COUNT_NUMBER;
import static lotto.constant.GameValue.MIN_BUYING_AMOUNT;

import java.util.List;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.view.InputView;

public class InputMiddleController {
    private final InputView inputView;

    public InputMiddleController(InputView inputView) {
        this.inputView = inputView;
    }

    public int getValidatedBuyingAmount() {
        while (true) {
            try {
                String buyingAmount = inputView.startLottoGameAndReadBuyingPrice();
                return parseAndValidateAmount(buyingAmount) / DIVIDE_FOR_TICKET_COUNT_NUMBER.getValue();
            } catch (IllegalArgumentException e) {
                System.out.println(PRINT_ERROR_MESSAGE.getMessage() + e.getMessage());
            }
        }
    }

    private int parseAndValidateAmount(String buyingAmount) {
        if (!buyingAmount.matches("\\d+")) {
            throw new IllegalArgumentException(INVALID_NUMERIC_INPUT.getMessage());
        }
        int amount = Integer.parseInt(buyingAmount);
        if (amount <= MIN_BUYING_AMOUNT.getValue() || amount % DIVIDE_FOR_TICKET_COUNT_NUMBER.getValue() != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
        return amount;
    }

    public WinningLotto getValidatedWinningLotto() {
        Lotto validatedWinningNumbers = getValidatedWinningNumbers();
        Bonus validatedBonusNumber = getValidatedBonusNumber(validatedWinningNumbers);
        return getValidatedWinningLotto(validatedWinningNumbers, validatedBonusNumber);
    }

    private Lotto getValidatedWinningNumbers() {
        while (true) {
            try {
                List<Integer> numbers = inputView.readWinningNumbers();
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(PRINT_ERROR_MESSAGE.getMessage() + e.getMessage());
            }
        }
    }

    private Bonus getValidatedBonusNumber(Lotto lotto) {
        while (true) {
            try {
                int bonusNumber = Integer.parseInt(inputView.readBonusNumber());
                return new Bonus(bonusNumber, lotto);
            } catch (IllegalArgumentException e) {
                System.out.println(PRINT_ERROR_MESSAGE.getMessage() + e.getMessage());
            }
        }
    }

    public WinningLotto getValidatedWinningLotto(Lotto lotto, Bonus bonus) {
        return new WinningLotto(lotto, bonus);
    }
}
