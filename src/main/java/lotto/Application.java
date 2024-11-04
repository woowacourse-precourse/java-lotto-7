package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // 로또 구입 및 검증
        int lottoPurchaseAmount = getValidatedPurchaseAmount();

        // 당첨 번호와 보너스 번호 입력 및 검증
        List<Integer> winningNumbers = getValidatedWinningNumbers();
        int bonusNumber = getValidatedBonusNumber(winningNumbers);

    }

    private static int getValidatedPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                int lottoPurchaseAmount = Integer.parseInt(Console.readLine());
                validatePurchaseAmount(lottoPurchaseAmount);
                return lottoPurchaseAmount;

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자 형식이 올바르지 않습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 금액 유효성 검증 메서드
    public static void validatePurchaseAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1보다 커야 합니다.");
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    // 당첨 번호 입력 및 유효성 검증
    private static List<Integer> getValidatedWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                List<Integer> winningNumbers = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                WinningNumbersValidator.validateWinningNumbers(winningNumbers, -1); // 보너스 번호는 -1로 설정하여 일단 무시
                return winningNumbers;

            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    // 보너스 번호 입력 및 유효성 검증
    private static int getValidatedBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonusNumber = Integer.parseInt(Console.readLine());

                WinningNumbersValidator.validateWinningNumbers(winningNumbers, bonusNumber); // 당첨 번호와 보너스 번호 검증
                return bonusNumber;

            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}
