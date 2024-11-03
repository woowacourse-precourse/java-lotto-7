package lotto.validator;

import static lotto.validator.NumberParser.DELIMITER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberValidator {

    public boolean validateWinningNumbers(String input) {
        try {
            List<Integer> numbers;

            input = input.replaceAll(" ", "");
            checkEmptyNumber(input);
            checkDelimiter(input);
            numbers = NumberParser.toNumbers(input);
            isSixNumbers(numbers);
            checkWinningNumbersRange(numbers);

            return true;
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean validateBonusNumber(String bonusNumber) {
        try {
            int number;

            bonusNumber = bonusNumber.replaceAll(" ", "");
            checkEmptyNumber(bonusNumber);
            isBonusNumber(bonusNumber);
            number = Integer.parseInt(bonusNumber);
            checkBonusNumberRange(number);

            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean duplicateNumber(List<Integer> winningNumbers, int bonusNumber) {
        try {
            checkBonusNumberInWinningNumbers(winningNumbers, bonusNumber);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void checkEmptyNumber(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 번호를 입력해주세요.");
        }
    }

    private void checkDelimiter(String winningNumbers) {
        if (!winningNumbers.contains(DELIMITER)) {
            throw new NullPointerException("[ERROR] 구분자는 쉼표(,)로 구분해주세요");
        }
    }

    private void isSixNumbers(List<Integer> winningNumbers) {
        Set<Integer> sixNumber = new HashSet<>(winningNumbers);
        if (sixNumber.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개를 입력해주세요.");
        }
    }

    private void checkWinningNumbersRange(List<Integer> winningNumbers) {
        for (Integer number : winningNumbers) {
            if (1 > number || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45사이의 정수입니다.");
            }
        }
    }

    private void isBonusNumber(String bonusNumber) {
        if (!bonusNumber.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private void checkBonusNumberRange(int bonusNumber) {
        if (1 > bonusNumber || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 정수입니다.");
        }
    }

    private void checkBonusNumberInWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        Set<Integer> check = new HashSet<>(winningNumbers);
        check.add(bonusNumber);

        if (check.size() == winningNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다. " + winningNumbers);
        }
    }
}
