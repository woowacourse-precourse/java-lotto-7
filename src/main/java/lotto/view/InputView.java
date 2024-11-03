package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static final int WINNING_NUMBER_COUNT = 6;

    public static int getPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        return getValidatedIntegerInput();
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요. (예: 1,2,3,4,5,6)");
        while (true) {
            String input = Console.readLine().trim();
            try {
                return parseWinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return getValidatedIntegerInput();
    }

    private static int getValidatedIntegerInput() {
        while (true) {
            try {
                return Integer.parseInt(Console.readLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            }
        }
    }

    private static List<Integer> parseWinningNumbers(String input) {
        validateWinningNumbersFormat(input);
        return convertToIntegerList(input.split(","));
    }

    private static void validateWinningNumbersFormat(String input) {
        String[] numberStrings = input.split(",");
        if (numberStrings.length != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분된 6개의 숫자여야 합니다.");
        }
    }

    private static List<Integer> convertToIntegerList(String[] numberStrings) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            try {
                winningNumbers.add(Integer.parseInt(numberString.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 입력해 주세요.");
            }
        }
        return winningNumbers;
    }
}
