package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.validator.PurchaseAmountValidator;

public class InputView {
    private static String readInput() {
        return Console.readLine();
    }

    public static int readPurchaseAmount() {
        while (true) {
            try {
                return PurchaseAmountValidator.validate(readInput());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public static List<Integer> readWinningNumbers() {
        String input = readInput();
        String[] winningNumbers = input.split(",");

        return convertStringArrayToIntegerList(winningNumbers);
    }

    private static List<Integer> convertStringArrayToIntegerList(String[] numbers) {
        List<Integer> result = new ArrayList<>();
        for (String number : numbers) {
            result.add(Integer.parseInt(number));
        }
        return result;
    }

    public static int readBonusNumber() {
        return Integer.parseInt(readInput());
    }
}
