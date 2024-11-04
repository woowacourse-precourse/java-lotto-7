package lotto.validator;

import java.util.Set;

public class InputWinningNumbersValidator {

    public static void validateWinningNumbers(String winningNumbersInput) {

        if (!winningNumbersInput.matches("^\\d+(,\\d+)*$")) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 쉼표(,)를 기준으로, 6개 입력해 주세요.");
        }

        String[] inputNumbers = winningNumbersInput.split(",");
        if (inputNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 쉼표(,)를 기준으로, 6개 입력해 주세요.");
        }

        validateInputNumbers(inputNumbers);
    }

    private static void validateInputNumbers(String[] inputNumbers) {

        for (String inputNumber : inputNumbers) {

            int number = Integer.parseInt(inputNumber);
            if (number <= 0 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static void validateDuplicateWinningNumbers(Set<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복일 수 없습니다.");
        }
    }
}
