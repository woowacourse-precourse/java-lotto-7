package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static int getPurchaseAmount() {
        System.out.println("\n구입금액을 입력해 주세요.");
        return parseInputToInt(Console.readLine(), "[ERROR] 구입금액은 숫자여야 합니다.");
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
            int number = parseInputToInt(inputNumber, "[ERROR] 로또 번호는 숫자여야 합니다.");
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
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (existingNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public static int getBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int input = parseInputToInt(Console.readLine(), "[ERROR] 보너스 번호는 숫자여야 합니다.");
        validateBonusNumber(input);
        return input;
    }

    private static void validateBonusNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
