package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int inputPurchaseAmount() {
        try {
            int purchaseAmount = Integer.parseInt(Console.readLine());
            validatePurchaseAmount(purchaseAmount);
            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 이상이어야 합니다.");
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위여야 합니다.");
        }
    }

    public static List<Integer> inputWinningNumber() {
        List<Integer> numbers = new ArrayList<>();
        String[] inputNumbers = Console.readLine().split(",");
        try {
            for(String inputNumber : inputNumbers) {
                numbers.add(Integer.parseInt(inputNumber));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }

        validateWinningNumber(numbers);

        return numbers;
    }

    private static void validateWinningNumber(List<Integer> winningNumber) {
        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        // 1~45 사이의 숫자인지 확인
        for (int number : winningNumber) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이여야 합니다.");
            }
        }
        // 중복된 숫자가 있는지 확인
        if (winningNumber.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
        }
    }

    public static int inputBonusNumber() {
        try {
            int bonusNumber = Integer.parseInt(Console.readLine());
            validateBonusNumber(bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이여야 합니다.");
        }
    }
}
