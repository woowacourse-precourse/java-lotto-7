package view;

import camp.nextstep.edu.missionutils.Console;
import purchase.PurchaseAmount;

public class InputView {
    public static PurchaseAmount readPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        try {
            int amount = Integer.parseInt(input);
            return new PurchaseAmount(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }
}
