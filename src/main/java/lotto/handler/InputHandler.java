package lotto.handler;

import static lotto.message.OutputMessage.BONUS_NUMBER_INPUT_MESSAGE;
import static lotto.message.OutputMessage.PURCHASE_AMOUNT_INPUT_MESSAGE;
import static lotto.message.OutputMessage.WINNING_NUMBERS_INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningLottoValidator;

public class InputHandler {
    public int readPurchaseAmountInput() {
        while (true) {
            try {
                System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE.getMessage());
                String input = Console.readLine();
                return PurchaseAmountValidator.validatePurchaseAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public List<Integer> readWinningNumbersInput() {
        while (true) {
            try {
                System.out.println(WINNING_NUMBERS_INPUT_MESSAGE.getMessage());
                String input = Console.readLine();
                return WinningLottoValidator.validateWinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int readBonusNumberInput(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println(BONUS_NUMBER_INPUT_MESSAGE.getMessage());
                String input = Console.readLine();
                return BonusNumberValidator.validateBonusNumber(input, winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
