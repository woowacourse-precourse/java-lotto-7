package lotto.view;

import static lotto.constants.InputMessages.*;
import static lotto.validator.LottoNumberValidator.validateRange;

import lotto.parser.BonusNumberParser;
import lotto.parser.PurchaseAmountParser;
import lotto.parser.WinningNumbersParser;
import lotto.validator.PurchaseAmountValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public static int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println(INPUT_PURCHASE_AMOUNT);
                String input = Console.readLine();
                int amount = PurchaseAmountParser.parse(input);
                PurchaseAmountValidator.validate(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                System.out.println(INPUT_WINNING_NUMBERS);
                String input = Console.readLine();
                return WinningNumbersParser.parse(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int inputBonusNumber() {
        while (true) {
            try {
                System.out.println(INPUT_BONUS_NUMBER);
                String input = Console.readLine();
                int bonusNumber = BonusNumberParser.parse(input);
                validateRange(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
