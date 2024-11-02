package lotto.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberValidator {

    private static final String delimiter = ",";
    
    public boolean validateWinningNumbers(String input) {
        try {
            List<Integer> numbers;

            input = input.replaceAll(" ", "");
            isEmptyNumber(input);
            checkDelimiter(input);
            numbers = isExistLetter(input);
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
            isEmptyNumber(bonusNumber);
            isNumber(bonusNumber);
            number = Integer.parseInt(bonusNumber);
            checkBonusNumberRange(number);

            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //공통
    private void isEmptyNumber(String winningNumbers) {
        if (winningNumbers == null || winningNumbers.isEmpty()) {
            throw new IllegalArgumentException("[Error] 번호를 입력해주세요.");
        }
    }

    //보너스 번호 관련
    private void isNumber(String bonusNumber) {
        if (!bonusNumber.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[Error] 1부터 45사이의 숫자를 입력해주세요.");
        }
    }

    private void checkBonusNumberRange(int number) {
        if (1 > number || number > 45) {
            throw new IllegalArgumentException("[Error] 보너스 번호는 1부터 45 사이의 정수입니다.");
        }
    }

    //당첨 번호 관련
    private void checkWinningNumbersRange(List<Integer> winningNumbers) {
        for (Integer number : winningNumbers) {
            if (1 > number || number > 45) {
                throw new IllegalArgumentException("[Error] 당첨 번호는 1부터 45사이의 정수입니다.");
            }
        }
    }

    private void checkDelimiter(String winningNumbers) {
        if (!winningNumbers.contains(delimiter)) {
            throw new NullPointerException("[Error] 구분자는 쉼표(,)로 구분해주세요");
        }
    }

    private List<Integer> isExistLetter(String winningNumbers) {
        try {
            List<String> numbers = toNumbers(winningNumbers);
            List<Integer> toNumbers = new ArrayList<>();
            for (String number : numbers) {
                toNumbers.add(Integer.parseInt(number));
            }
            return toNumbers;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[Error] 숫자를 입력해 주세요.");
        }
    }

    private void isSixNumbers(List<Integer> winningNumbers) {
        Set<Integer> sixNumber = new HashSet<>(winningNumbers);
        if (sixNumber.size() != 6) {
            throw new IllegalArgumentException("[Error] 당첨 번호는 6개를 입력해주세요.");
        }
    }

    private List<String> toNumbers(String winningNumbers) {
        String[] numbers = winningNumbers.split(delimiter);
        return new ArrayList<>(Arrays.asList(numbers));
    }
}
