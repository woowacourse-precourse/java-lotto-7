package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = readValidPurchaseAmount();
        System.out.println("Final purchase amount: " + purchaseAmount);
    }

    private static int readValidPurchaseAmount() {
        while (true) {
            System.out.println("Enter the purchase amount:");
            String input = Console.readLine();

            try {
                int amount = Integer.parseInt(input);
                validateAmount(amount);  // 유효성 검증
                return amount;  // 유효한 금액이면 반환
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());  // [ERROR] 메시지 출력 후 재입력
            }
        }
    }

    private static void validateAmount(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] The purchase amount should be a positive multiple of 1,000.");
        }
    }
}
