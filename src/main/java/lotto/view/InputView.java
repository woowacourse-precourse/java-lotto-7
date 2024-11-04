package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static final String PURCHASE_AMOUNT_PROMPT = "구입 금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private static final String NUMBER_ERROR_MESSAGE = "[ERROR] 숫자를 입력해 주세요.";
    private static final String WINNING_NUMBER_PARSE_ERROR = "[ERROR] 당첨 번호는 숫자만 입력해 주세요.";

    public static int getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_PROMPT);
        int amount = readValidatedIntegerInput();
        InputValidator.validatePurchaseAmount(amount);
        System.out.println();
        return amount;
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println(WINNING_NUMBERS_PROMPT);
        String input = Console.readLine().trim();
        List<Integer> winningNumbers = parseWinningNumbers(input);

        InputValidator.validateSize(winningNumbers);
        InputValidator.validateNoDuplicateNumbers(winningNumbers);
        InputValidator.validateNumberRange(winningNumbers);

        return winningNumbers;
    }

    public static int getBonusNumber() {
        System.out.println(BONUS_NUMBER_PROMPT);
        int bonusNumber = readValidatedIntegerInput();
        InputValidator.validateSingleNumberRange(bonusNumber);
        System.out.println();
        return bonusNumber;
    }


    private static int readValidatedIntegerInput() {
        String input = Console.readLine().trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }


    // 당첨 번호 파싱 및 검증 메서드
    private static List<Integer> parseWinningNumbers(String input) {
        String[] numberStrings = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            try {
                winningNumbers.add(Integer.parseInt(numberString.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(WINNING_NUMBER_PARSE_ERROR, e);
            }
        }
        System.out.println();
        return winningNumbers;
    }
}
