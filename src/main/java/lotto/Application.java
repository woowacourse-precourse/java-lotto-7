package lotto;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        try {
            int purchaseAmount = getPurchaseAmount();
            System.out.println("구입 금액: " + purchaseAmount + "원");
            // 이후의 기능을 차례로 추가할 수 있습니다.
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    // 구입 금액 입력 및 검증
    private static int getPurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입 금액을 입력해 주세요.");

        int amount = scanner.nextInt();

        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해야 합니다.");
        }

        return amount;
    }
}
