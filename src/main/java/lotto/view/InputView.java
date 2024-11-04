package lotto.view;

import static lotto.util.ValidationUtils.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public long getPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                String userInput = Console.readLine().trim();

                validateNotEmpty(userInput);
                validateIsNumber(userInput);

                long purchaseAmount = Long.parseLong(userInput);
                validatePositive(purchaseAmount);
                validateThousandUnit(purchaseAmount);

                return purchaseAmount;

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력 값이 너무 큽니다. 다시 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요 (쉼표로 구분).");
                String userInput = Console.readLine().trim();

                List<Integer> winningNumbers = parseWinningNumbers(userInput);
                validateWinningNumbers(winningNumbers);

                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String userInput = Console.readLine().trim();

                int bonusNumber = Integer.parseInt(userInput);
                validateBonusNumber(bonusNumber, winningNumbers);

                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력 값은 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> parseWinningNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 숫자여야 합니다.");
        }
    }
}
