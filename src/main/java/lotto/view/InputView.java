package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PurchaseAmount;

public class InputView {

    public static PurchaseAmount readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return PurchaseAmount.from(Integer.parseInt(Console.readLine()));
    }
}
