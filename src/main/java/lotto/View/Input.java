package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Input {
    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int amount = Integer.parseInt(Console.readLine());
            validatePurchaseAmount(amount);  // 구입 금액 검증
            return amount;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 잘못된 금액 형식입니다. 숫자만 입력해 주세요.");
            return inputPurchaseAmount();  // 다시 입력 받기
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());  // "[ERROR]" 메시지 출력
            return inputPurchaseAmount();  // 다시 입력 받기
        }
    }

    public static Set<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            return Arrays.stream(Console.readLine().split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 당첨 번호는 숫자여야 하며, 콤마로 구분해야 합니다.");
            return inputWinningNumbers();  // 다시 입력 받기
        }
    }

    public static int inputBonusNumber(Set<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            int bonusNumber = Integer.parseInt(Console.readLine());
            validateBonusNumber(bonusNumber, winningNumbers);  // 보너스 번호 검증
            return bonusNumber;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 보너스 번호는 숫자여야 합니다.");
            return inputBonusNumber(winningNumbers);  // 다시 입력 받기
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());  // "[ERROR]" 메시지 출력
            return inputBonusNumber(winningNumbers);  // 다시 입력 받기
        }
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    private static void validateBonusNumber(int bonusNumber, Set<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
