package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 구매 금액 입력
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = inputPurchaseAmount();


    }

    private static int inputPurchaseAmount() {
        return Integer.parseInt(Console.readLine());
    }
}
