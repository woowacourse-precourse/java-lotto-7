package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    private void validateNumberOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void printRequestingMoneyInput() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    private void printRequestingLottoWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private String getUserInput() {
        return Console.readLine();
    }

    private int validateNumberInput(String userInput) {
        try {
            int userIntInput = Integer.parseInt(userInput);

            if (userIntInput < 0) {
                throw new IllegalArgumentException("[ERROR] 음수는 입력할 수 없습니다.");
            }

            return userIntInput;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }

    private void validateDivisibilityBy1000(int userInput) {
        if (userInput % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000 단위여야 합니다.");
        }
    }
}
