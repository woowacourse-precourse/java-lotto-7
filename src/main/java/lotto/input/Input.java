package lotto.input;

import static lotto.constants.ErrorMessage.INPUT_MUST_BE_NUMBER;
import static lotto.constants.InputPrompts.ENTER_BONUS_NUMBER;
import static lotto.constants.InputPrompts.ENTER_PURCHASE_AMOUNT;
import static lotto.constants.InputPrompts.ENTER_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {

    public static Purchase getPurchaseAmount() {
        while (true) {
            System.out.println(ENTER_PURCHASE_AMOUNT.getPrompt());

            try {
                return new Purchase(Integer.parseInt(Console.readLine().replaceAll(" ", "")));
            } catch (NumberFormatException e) {
                System.out.println(INPUT_MUST_BE_NUMBER.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Lotto getWinningNumbers() {
        while (true) {
            System.out.println("\n" + ENTER_WINNING_NUMBERS.getPrompt());

            try {
                List<String> winningNumbersInput = List.of(Console.readLine().replaceAll(" ", "").split(","));
                List<Integer> winningNumbers = covertStringToInteger(winningNumbersInput);
                return new Lotto(winningNumbers);
            } catch (NumberFormatException e) {
                System.out.println(INPUT_MUST_BE_NUMBER.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> covertStringToInteger(List<String> winningNumbersInput) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String input : winningNumbersInput) {
            winningNumbers.add(Integer.parseInt(input));
        }
        return winningNumbers;
    }

    public static Bonus getBonusNumber(Lotto lotto) {
        while (true) {
            System.out.println("\n" + ENTER_BONUS_NUMBER.getPrompt());

            try {
                return new Bonus(lotto, Integer.parseInt(Console.readLine().replaceAll(" ", "")));
            } catch (NumberFormatException e) {
                System.out.println(INPUT_MUST_BE_NUMBER.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
