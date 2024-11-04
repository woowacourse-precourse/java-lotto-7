package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class UserInputConverter {
    private List<Integer> winningNumbers;

    public int getCost() {
        boolean validated = false;
        String userInput = "";
        System.out.println("구입금액을 입력해 주세요.");
        while (!validated) {
            try {
                userInput = Console.readLine();
                validated = validateCost(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(userInput);
    }

    private boolean validateCost(String userInput) {
        int cost = 0;
        cost = validateNumberFormat(userInput);
        validatePaid(cost);
        return true;
    }

    public List<Integer> getWinningNumbers() {
        boolean validated = false;
        String userWinningNumbers = "";
        System.out.println("당첨 번호를 입력해 주세요.");
        while (!validated) {
            try {
                userWinningNumbers = Console.readLine();
                validated = validateWinningNumbers(userWinningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        this.winningNumbers = Arrays.stream(userWinningNumbers.split(",")).map(Integer::parseInt).toList();
        return this.winningNumbers;
    }

    private boolean validateWinningNumbers(String userWinningNumbers) {
        List<Integer> numbers;
        numbers = validateNumbersFormat(userWinningNumbers);
        validateUnique(numbers);
        validateInRange(numbers);
        validateSixNumbers(numbers);
        return true;
    }

    public int getBonusNumber() {
        boolean validated = false;
        String userBonusNumber = "";
        System.out.println("보너스 번호를 입력해 주세요.");
        while (!validated) {
            try {
                userBonusNumber = Console.readLine();
                validated = validateBonusNumber(userBonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(userBonusNumber);
    }

    private boolean validateBonusNumber(String userBonusNumber) {
        int bonusNumber = 0;
        bonusNumber = validateNumberFormat(userBonusNumber);
        validateInRange(bonusNumber);
        validateDifferentBetweenWinningNumbers(bonusNumber);
        return true;
    }

    private void validateDifferentBetweenWinningNumbers(int bonusNumber) {
        if (this.winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 달라야 합니다.");
        }
    }

    private static void validatePaid(int cost) {
        if (cost < 0 || cost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 0 이상의 1000원 단위 이어야 합니다.");
        }
    }

    private static int validateNumberFormat(String userInput) {
        int cost;
        try {
            cost = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 숫자 형식을 입력해야합니다.");
        }
        return cost;
    }

    private static List<Integer> validateNumbersFormat(String userWinningNumbers) {
        List<Integer> numbers;
        try {
            numbers = Arrays.stream(userWinningNumbers.split(",")).map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식을 입력해야합니다.");
        }
        return numbers;
    }

    private static void validateInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateInRange(number);
        }
    }

    private static void validateInRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개 이어야 합니다.");
        }
    }

    private static void validateUnique(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복 숫자 없이 전부 달라야 합니다.");
        }
    }
}
