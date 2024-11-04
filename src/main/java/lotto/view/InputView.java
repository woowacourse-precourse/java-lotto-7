package lotto.view;

import static lotto.constants.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.constants.ErrorMessages.*;
import static lotto.constants.InputMessages.*;
import static lotto.validator.LottoNumberValidator.validateRange;

import lotto.validator.PurchaseAmountValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println(INPUT_PURCHASE_AMOUNT);
                String input = Console.readLine();
                int amount = parsePurchaseAmount(input);
                PurchaseAmountValidator.validate(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int parsePurchaseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PURCHASE_AMOUNT_NUMERIC);
        }
    }

    public static List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                System.out.println(INPUT_WINNING_NUMBERS);
                String input = Console.readLine();
                return parseWinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> parseWinningNumbers(String input) {
        String[] inputs = input.split(",");
        if (inputs.length != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBER_COUNT);
        }
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : inputs) {
            int num = parseNumber(number.trim());
            validateRange(num);
            if (winningNumbers.contains(num)) {
                throw new IllegalArgumentException(ERROR_WINNING_NUMBER_DUPLICATE);
            }
            winningNumbers.add(num);
        }
        return winningNumbers;
    }

    public static int inputBonusNumber() {
        while (true) {
            try {
                System.out.println(INPUT_BONUS_NUMBER);
                String input = Console.readLine();
                int bonusNumber = parseNumber(input);
                validateRange(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NUMBER_NUMERIC);
        }
    }
}
