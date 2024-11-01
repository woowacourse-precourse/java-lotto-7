package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputPrice {
    public static int getAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        int amount = 0;
        try {
            amount = Integer.parseInt(Console.readLine());
            validateAmount(amount);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 유효한 금액을 입력해주세요.");
            return getAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getAmount();
        }
        return amount;
    }

    private static void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}
