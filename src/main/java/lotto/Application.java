package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int lottoPurchaseAmount = getValidatedPurchaseAmount();
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
}
