package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public int readPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                return validatePurchaseAmount(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int validatePurchaseAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            if (amount < 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 음수가 될 수 없습니다.");
            }

            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자를 입력해 주세요.");
        }
    }

    public List<Integer> readWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                return validateWinningNumbers(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> validateWinningNumbers(String input) {
        List<Integer> numbers = parseNumbers(input);
        validateNumberCount(numbers);
        validateNumberRange(numbers);
        validateNoDuplicates(numbers);
        return numbers;
    }

    private List<Integer> parseNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 당첨 번호를 입력해 주세요.");
        }
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    public int readBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                return validateBonusNumber(Console.readLine(), winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int validateBonusNumber(String input, List<Integer> winningNumbers) {
        int bonusNumber = parseBonusNumber(input);
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberNotInWinning(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private int parseBonusNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 보너스 번호를 입력해 주세요.");
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateBonusNumberNotInWinning(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}