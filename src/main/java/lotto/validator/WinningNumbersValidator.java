package lotto.validator;

import java.util.Set;
import java.util.TreeSet;

public class WinningNumbersValidator {
    public Set<Integer> validateWinningNumbers(String winningNumbersInput) {
        if (!winningNumbersInput.matches("^\\d+(,\\d+)*$")) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 쉼표(,)를 기준으로, 6개 입력해 주세요.");
        }
        String[] inputNumbers = winningNumbersInput.split(",");
        if (inputNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 쉼표(,)를 기준으로, 6개 입력해 주세요.");
        }

        Set<Integer> winningNumbers = new TreeSet<>();
        for (String inputNumber : inputNumbers) {
            if (!isNumeric(inputNumber)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자로 입력해 주세요.");
            }

            int number = Integer.parseInt(inputNumber);
            if (number <= 0) {
                throw new IllegalArgumentException("[ERROR] 1 이상의 양수로 입력해 주세요.");
            }
            if (number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            winningNumbers.add(number);
        }
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복일 수 없습니다.");
        }

        return winningNumbers;
    }

    private static boolean isNumeric(String inputPrice) {
        return inputPrice.chars().allMatch(Character::isDigit);
    }
}
