package lotto.view;

import static lotto.message.MessageConstants.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.message.MessageConstants.INPUT_PURCHASE_AMOUNT_MESSAGE;
import static lotto.message.MessageConstants.INPUT_WINNING_NUMBERS_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.dto.BonusNumberDto;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningNumbersValidator;

public class InputView {

    public String inputPurchaseAmount() {
        while (true) {
            System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);

            try {
                String purchaseAmount = Console.readLine().trim();
                PurchaseAmountValidator.validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String inputWinningNumbers() {
        while (true) {
            System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);

            try {
                String winningNumbers = Console.readLine().trim();
                WinningNumbersValidator.validateWinningNumbers(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            System.out.println(INPUT_BONUS_NUMBER_MESSAGE);

            try {
                String bonusNumber = Console.readLine().trim();
                BonusNumberValidator.validateBonusNumber(winningNumbers, bonusNumber);
                return new BonusNumberDto(bonusNumber).parseBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
