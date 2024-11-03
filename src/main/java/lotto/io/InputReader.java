package lotto.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.validation.InputValidator;

public class InputReader {
    private static final int DIVISION_UNIT = 1000;

    public static int totalPurchaseAmount() {
        while (true) {
            try {
                int amount = stringToInt(readInput());
                InputValidator.purchaseAmountValidate(amount);
                return amount / DIVISION_UNIT;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> winningNumbers() {
        while (true) {
            try {
                List<Integer> winningNumbers = Arrays.stream(readInput().split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                InputValidator.winningNumbersValidate(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int bonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                int bonusNumber = stringToInt(readInput());
                InputValidator.bonusNumberValidate(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String readInput() {
        return Console.readLine();
    }

    private static int stringToInt(String string) {
        try {
            InputValidator.integerValidate(string);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return Integer.parseInt(string);
    }
}
