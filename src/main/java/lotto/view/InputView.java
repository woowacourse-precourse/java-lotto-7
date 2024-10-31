package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public Integer inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("올바른 숫자를 입력해 주세요.");
            return inputPurchaseMoney();
        }
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");

        try {
            List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .toList();

            validateWinningNumbers(winningNumbers);

            return winningNumbers;
        } catch (NumberFormatException e) {
            System.out.println("올바른 숫자를 입력해 주세요.");
            return inputWinningNumbers();
        }
    }

    public int inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("올바른 숫자를 입력해 주세요.");
            return inputBonusNumber();
        }
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이여야 합니다.");
        }
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (winningNumbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45사이여야 합니다.");
        }
    }
}
