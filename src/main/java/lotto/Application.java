package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            int purchaseAmount = getPurchaseAmount();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int amount = Integer.parseInt(input);
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력이 가능합니다.");
        }
    }
}
