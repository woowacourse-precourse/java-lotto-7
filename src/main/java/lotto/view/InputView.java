package lotto.view;


import lotto.constants.ErrorMessages;
import lotto.constants.Messages;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static int readPurchaseAmount() {
        while (true) {
            try {
                System.out.println(Messages.INPUT_PURCHASE_AMOUNT);
                String input = readLine();
                validateNumber(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> readWinningNumbers() {
        while (true) {
            try {
                System.out.println(Messages.INPUT_WINNING_NUMBERS);
                String input = readLine();
                return parseNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int readBonusNumber() {
        while (true) {
            try {
                System.out.println(Messages.INPUT_BONUS_NUMBER);
                String input = readLine();
                validateNumber(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> parseNumbers(String input) {
        String[] splitInput = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String number : splitInput) {
            validateNumber(number);
            numbers.add(Integer.parseInt(number.trim()));
        }

        return numbers;
    }

    private static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_NUMBERS_ONLY);
        }
    }
}

