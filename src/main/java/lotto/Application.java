package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {

        int purchaseAmount = readPurchaseAmount();


    }

    private static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요");
        int amount = Integer.parseInt(Console.readLine());
        validateAmount(amount);
        return amount;
    }

    private static void validateAmount(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
        }
    }
}


