package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String purchaseAmount = promptPurchaseAmount();
    }

    public static String promptPurchaseAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String purchaseAmount = Console.readLine();

            if (isValidPurchaseAmount(purchaseAmount)) {
                return purchaseAmount;
            }

            handleInvalidPurchaseAmount();
        }
    }

    public static boolean isValidPurchaseAmount(String purchaseAmount) {
        if (purchaseAmount.isBlank()) {
            return false;
        }

        try {
            return Integer.parseInt(purchaseAmount) >= 1000 && Integer.parseInt(purchaseAmount) % 1000 == 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void handleInvalidPurchaseAmount() {
        try {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위입니다. 유효한 금액을 입력해주세요.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
