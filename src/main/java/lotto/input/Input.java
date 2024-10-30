package lotto.input;

import static lotto.constants.ErrorMessage.INPUT_MUST_BE_NUMBER;
import static lotto.constants.InputPrompts.ENTER_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {

    public static Purchase getPurchaseAmount() {
        while (true) {
            System.out.println(ENTER_PURCHASE_AMOUNT.getPrompt());

            try {
                return new Purchase(Integer.parseInt(Console.readLine()));
            } catch (NumberFormatException e) {
                System.out.println(INPUT_MUST_BE_NUMBER.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Lotto getWinningNumbers() {
        while (true) {
            System.out.println(ENTER_PURCHASE_AMOUNT.getPrompt());

            try {
                List<String> winningNumbersInput = List.of(Console.readLine().split(","));
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
}
