package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
            int purchaseAmount = getPurchaseAmount();
    }

    // 구입 금액 입력 처리
    private static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        if (amount < 1000 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 유효한 금액을 입력해 주세요 (1,000원 단위).");
        }
        return amount;
    }

}