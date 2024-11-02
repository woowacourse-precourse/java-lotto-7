package lotto.view;

import static lotto.constants.LottoGeneratorConstants.LOTTO_PRICE;

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
                int purchaseAmount = Integer.parseInt(inputAmount);
                validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessages.PURCHASE_AMOUNT_NOT_NUMBER);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validatePurchaseAmount(int amount) {
        if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PURCHASE_AMOUNT);
        }
    }

    public WinningNumbers inputWinningNumbers() {
        while (true) {
            try {
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
