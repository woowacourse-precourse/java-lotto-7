package View;

import camp.nextstep.edu.missionutils.Console;

public class LottoView {
    public String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        return purchaseAmount;
    }
}
