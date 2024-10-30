package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.util.PurchaseUtils.getThousandUnitCount;

public class InputView {
    public int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputPurchaseAmount = Console.readLine();
        return getThousandUnitCount(inputPurchaseAmount);
    }
}
