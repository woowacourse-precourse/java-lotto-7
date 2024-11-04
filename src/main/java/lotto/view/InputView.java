package lotto.view;


import static lotto.enums.ViewConstants.PRINT_BONUS_NUMBER;
import static lotto.enums.ViewConstants.PRINT_PURCHASE_PRICE;
import static lotto.enums.ViewConstants.PRINT_WINNING_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PriceValidator;
import lotto.validator.WinningNumberValidator;


public class InputView {


    public int printGetPurchasePrice(PriceValidator validator) {
        while (true) {
            try {
                System.out.println(PRINT_PURCHASE_PRICE);
                String input = Console.readLine();
                return validator.validatePrice(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public String printGetWinningLottoNumber(WinningNumberValidator validator) {
        while (true) {
            try {
                System.out.println(PRINT_WINNING_NUMBER);
                String input = Console.readLine();
                return validator.validateInput(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int printGetBonusNumber(BonusNumberValidator validator, String winningNumber) {
        while (true) {
            try {
                System.out.println();
                System.out.println(PRINT_BONUS_NUMBER);
                String input = Console.readLine();
                return validator.validateBonusNumber(input, winningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
