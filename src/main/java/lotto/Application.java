package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmount();
    }

    private static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        System.out.println();
        return purchaseAmount;
    }
}
