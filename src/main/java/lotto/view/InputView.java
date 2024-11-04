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
                validateIsZero(purchaseAmount);
                validateThousandUnit(purchaseAmount);

                System.out.println();
                return purchaseAmount;

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력 값이 너무 큽니다. 다시 입력해 주세요.");
                System.out.println();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
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

                System.out.println();
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
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

                System.out.println();
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력 값은 숫자여야 합니다.");
                System.out.println();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
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
            throw new IllegalArgumentException("[ERROR] 올바른 숫자를 입력해주세요.");
        }
    }
}
