package view;

import Model.ErrorMessages;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static int getPurchaseAmount() {
        System.out.println("\n구입금액을 입력해 주세요.");
        return parseInputToInt(Console.readLine(), ErrorMessages.INVALID_PURCHASE_AMOUNT);
    }

    public static List<Integer> getLotto() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return parseLottoInput(input);
    }

    private static List<Integer> parseLottoInput(String input) {
        List<String> splitedInput = Arrays.asList(input.split(","));
        splitedInput.replaceAll(String::trim);

        List<Integer> inputNumbers = new ArrayList<>();
        for (String inputNumber : splitedInput) {
            int number = parseInputToInt(inputNumber, ErrorMessages.LOTTO_NUMBER_NOT_INTEGER);
            validateLottoNumber(number, inputNumbers);
            inputNumbers.add(number);
        }
        return inputNumbers;
    }

    private static int parseInputToInt(String input, String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static void validateLottoNumber(int number, List<Integer> existingNumbers) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_NUMBER_RANGE);
        }
        if (existingNumbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_LOTTO_NUMBER);
        }
    }

    public static int getBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int input = parseInputToInt(Console.readLine(), ErrorMessages.BONUS_NUMBER_NOT_INTEGER);
        validateBonusNumber(input);
        return input;
    }

    private static void validateBonusNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_BONUS_NUMBER_RANGE);
        }
    }
}
