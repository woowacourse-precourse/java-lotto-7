package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {

    // 구매 금액 입력 받기
    public int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                String input = Console.readLine();
                int amount = parseToInt(input);
                validatePurchaseAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 구매 금액 유효성 검증
    private void validatePurchaseAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1,000원 단위여야 합니다.");
        }
    }

    // 당첨 번호 입력 받기
    public List<Integer> getWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                List<Integer> numbers = parseToIntegerList(input);
                validateWinningNumbers(numbers);
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 보너스 번호 입력 받기
    public int getBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                int bonusNumber = parseToInt(input);
                validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 입력 문자열을 정수로 변환
    private int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해 주세요.");
        }
    }

    // 쉼표로 구분된 입력을 정수 리스트로 변환
    private List<Integer> parseToIntegerList(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim) // 공백 제거
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분된 숫자여야 합니다.");
        }
    }

    // 당첨 번호 유효성 검증
    private void validateWinningNumbers(List<Integer> numbers) {
        checkWinningNumberSize(numbers);
        checkWinningNumberDuplicates(numbers);
        checkWinningNumberRange(numbers);
    }

    // 당첨 번호 개수 확인
    private void checkWinningNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    // 중복 여부 확인
    private void checkWinningNumberDuplicates(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }

    // 번호 범위 확인
    private void checkWinningNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberRange(number);
        }
    }

    // 개별 번호 범위 검증
    private void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 번호는 1에서 45 사이여야 합니다.");
        }
    }

    // 보너스 번호 유효성 검증
    private void validateBonusNumber(int bonusNumber) {
        validateNumberRange(bonusNumber);
    }
}
