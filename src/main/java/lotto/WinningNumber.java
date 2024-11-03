package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class WinningNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void inputWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        this.winningNumbers = parseWinningNumbers(input);
    }

    public List<Integer> parseWinningNumbers(String input) {
        List<Integer> numbers;
        try {
            numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 입력이 잘못되었습니다.");
        }
        validateWinningNumbers(numbers);
        this.winningNumbers = numbers;
        return numbers;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumberSize(winningNumbers);
        validateWinningNumbersRange(winningNumbers);
        validateWinningNumberDuplication(winningNumbers);
    }

    private void validateWinningNumberSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private void validateWinningNumbersRange(List<Integer> winningNumbers) {
        if (winningNumbers.stream().anyMatch(n -> n < MIN_NUMBER || n > MAX_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateWinningNumberDuplication(List<Integer> winningNumbers) {
        if (winningNumbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }

    public void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine().trim();
        this.bonusNumber = parseBonusNumber(input);
    }

    public int parseBonusNumber(String bonusNumber) {
        int number;
        try {
            number = Integer.parseInt(bonusNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호 입력이 잘못되었습니다.");
        }
        validateBonusNumber(number);
        return number;
    }

    private void validateBonusNumber(int bonusNumber) {
        validateNumber(bonusNumber);
        validateBonusNumberDuplication(bonusNumber);
    }

    private void validateNumber(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void validateBonusNumberDuplication(int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
