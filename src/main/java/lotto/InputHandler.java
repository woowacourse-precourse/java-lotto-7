package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.LottoConstants.LOTTO_PRICE;

public class InputHandler {
    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();
        try {
            int amount = Integer.parseInt(input);
            validatePurchaseAmount(amount);
            System.out.println();
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("[ERROR] 0 이상의 값을 입력해야 합니다.");
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] " + LOTTO_PRICE + "원으로 나누어 떨어지는 값을 입력해야 합니다.");
        }
    }
}