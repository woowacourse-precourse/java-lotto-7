package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int amount = getAmount();
        //int[] numbers = getNumbers();
    }

    public static int getAmount() {
        String inputAmount = Console.readLine();
        return validateAmountValue(inputAmount);
    }

    private static int validateAmountValue(String inputAmount) {
        try {
            int amount = Integer.parseInt(inputAmount);
            if (amount < 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 양수여야 합니다");
            }
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 타입입니다.");
        }

    }
}
