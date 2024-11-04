package lotto.service;

import lotto.model.Result;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class ResultService {

    public Result createResult() {
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers); // winningNumbers를 인자로 전달
        return new Result(winningNumbers, bonusNumber);
    }

    private void validateWinningNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateWinningNumberDuplicate(List<Integer> winningNumbers, int number) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호입니다: " + number);
        }
    }

    private List<Integer> getWinningNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 6) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String winningNumbersInput = Console.readLine();
            String[] splitNumbers = winningNumbersInput.split(",");
            try {
                for (String numberStr : splitNumbers) {
                    int number = Integer.parseInt(numberStr.trim());
                    validateWinningNumber(number);
                    validateWinningNumberDuplicate(numbers, number);
                    numbers.add(number);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                numbers.clear();
            }
        }
        return numbers;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplicateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        int bonusNumber;
        while (true) {
            System.out.print("보너스 번호를 입력해 주세요.");
            String bonusInput = Console.readLine();
            try {
                bonusNumber = Integer.parseInt(bonusInput);
                validateBonusNumber(bonusNumber);
                validateDuplicateBonusNumber(winningNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }
}
