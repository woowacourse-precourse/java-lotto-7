package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    public int readPurchaseAmount() {
        int amount = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                amount = validateAmount(Console.readLine());
                validInput = true; // 유효한 입력이면 true로 설정
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 에러 메시지 출력
            }
        }
        return amount;
    }

    private int validateAmount(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 금액을 입력해 주세요.");
        }
        try {
            int amount = Integer.parseInt(input);
            if (amount > 0 && amount % 1000 == 0) {
                return amount;
            }
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위의 양수로 입력해 주세요.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");  // ERROR_MESSAGE가 포함된 예외
        }
    }

    public List<Integer> readWinningNumbers() {
        List<Integer> numbers = null;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                numbers = parseWinningNumbers(Console.readLine());
                validInput = true; // 유효한 입력이면 true로 설정
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 에러 메시지 출력
            }
        }
        return numbers;
    }

    private List<Integer> parseWinningNumbers(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 입력해 주세요.");
        }

        try {
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            validateWinningNumbers(numbers);
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 입력해 주세요.");
        }
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6 || new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 중복되지 않는 숫자여야 합니다.");
        }

        numbers.forEach(number -> {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 범위여야 합니다.");
            }
        });
    }

    public int readBonusNumber(List<Integer> winningNumbers) {
        int bonusNumber = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                bonusNumber = validateBonusNumber(Console.readLine(), winningNumbers);
                validInput = true; // 유효한 입력이면 true로 설정
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 에러 메시지 출력
            }
        }
        return bonusNumber;
    }

    private int validateBonusNumber(String input, List<Integer> winningNumbers) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력해 주세요.");
        }

        try {
            int bonusNumber = Integer.parseInt(input);
            if (bonusNumber < 1 || bonusNumber > 45 || winningNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 범위이며 당첨 번호와 중복되지 않아야 합니다.");
            }
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력해 주세요.");
        }
    }

    public void testValidateAmount(String input) {
        validateAmount(input);
    }

    public List<Integer> testParseWinningNumbers(String input) {
        return parseWinningNumbers(input);
    }

    public void testValidateWinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbers(winningNumbers);
    }

    public int testValidateBonusNumber(String input, List<Integer> winningNumbers) {
        return validateBonusNumber(input, winningNumbers);
    }




}