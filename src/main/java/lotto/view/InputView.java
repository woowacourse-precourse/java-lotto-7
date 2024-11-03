package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static final int WINNING_NUMBER_COUNT = 6;
    private static final String PURCHASE_AMOUNT_PROMPT = "구입 금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private static final String NUMBER_ERROR_MESSAGE = "[ERROR] 숫자를 입력해 주세요.";
    private static final String WINNING_NUMBER_FORMAT_ERROR = "[ERROR] 당첨 번호는 쉼표로 구분된 6개의 숫자여야 합니다.";
    private static final String WINNING_NUMBER_PARSE_ERROR = "[ERROR] 당첨 번호는 숫자만 입력해 주세요.";
    private static final String AMOUNT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";

    public static int getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_PROMPT);
        int amount = readValidatedIntegerInput();

        // 1,000원 단위 검증
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(AMOUNT_ERROR_MESSAGE);
        }

        return amount;
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println(WINNING_NUMBERS_PROMPT);
        String input = Console.readLine().trim();
        return parseWinningNumbers(input);
    }

    public static int getBonusNumber() {
        System.out.println(BONUS_NUMBER_PROMPT);
        return readValidatedIntegerInput();
    }

    private static int readValidatedIntegerInput() {
        String input = Console.readLine().trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }

    private static List<Integer> parseWinningNumbers(String input) {
        validateWinningNumbersFormat(input);
        return convertToIntegerList(input.split(","));
    }

    private static void validateWinningNumbersFormat(String input) {
        String[] numberStrings = input.split(",");
        if (numberStrings.length != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(WINNING_NUMBER_FORMAT_ERROR);
        }
    }

    private static List<Integer> convertToIntegerList(String[] numberStrings) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            try {
                winningNumbers.add(Integer.parseInt(numberString.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(WINNING_NUMBER_PARSE_ERROR);
            }
        }
        return winningNumbers;
    }
}
