package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = getPurchaseAmount();
        System.out.println("구입 금액: " + purchaseAmount);
    }

    private static int getPurchaseAmount() {
        int amount = 0;

        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                amount = Integer.parseInt(Console.readLine());

                // 1000원 단위 확인하기
                if (amount <= 0 || amount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
                }
                break; // 유효한 금액이면 반복문 탈출

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return amount;
    }
}
