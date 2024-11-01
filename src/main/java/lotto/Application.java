package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            int purchaseAmount = readPurchaseAmount();
            System.out.println("Purchase amount: " + purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int readPurchaseAmount() {
        System.out.println("Enter the purchase amount:");
        String input = Console.readLine();

        try {
            int amount = Integer.parseInt(input);
            validateAmount(amount);  // 유효성 검증
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] The amount should be a valid integer.");
        }
    }

    private static void validateAmount(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] The purchase amount should be a positive multiple of 1,000.");
        }
    }
}
