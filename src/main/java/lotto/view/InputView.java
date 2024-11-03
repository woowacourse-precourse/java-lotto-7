package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.ErrorMessages;
import lotto.constants.InputMessages;
import lotto.domain.BonusNumber;
import lotto.domain.WinningNumbers;

public class InputView {
    public int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println(InputMessages.PURCHASE_AMOUNT_PROMPT);
                String inputAmount = Console.readLine();
                return Integer.parseInt(inputAmount);
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessages.PURCHASE_AMOUNT_NOT_NUMBER);
            }
        }
    }

    public WinningNumbers inputWinningNumbers() {
        while (true) {
            try {
                System.out.println();
                System.out.println(InputMessages.WINNING_NUMBERS_PROMPT);
                String input = Console.readLine();
                return new WinningNumbers(input);
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessages.INVALID_WINNING_NUMBER_COUNT);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public BonusNumber inputBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                System.out.println();
                System.out.println(InputMessages.BONUS_NUMBER_PROMPT);
                String input = Console.readLine();
                int bonusNumber = Integer.parseInt(input.trim());
                return new BonusNumber(bonusNumber, winningNumbers);
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessages.BONUS_NUMBER_NOT_NUMBER);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
