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
        for(String inputNumber : inputNumbers) {
            numbers.add(Integer.parseInt(inputNumber));
        }
        return numbers;
    }

    public static int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
