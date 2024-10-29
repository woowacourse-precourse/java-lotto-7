package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.contants.value.LottoValue;

public class InputView {
    public int purchasePrice() {
        String purchasePrice = Console.readLine();
        purchasePriceValidate(purchasePrice);

        return Integer.parseInt(purchasePrice);
    }

    public void purchasePriceValidate(String purchasePrice) {
        if ((Integer.parseInt(purchasePrice) % LottoValue.AMOUNT_UNIT) != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액 단위는 1,000원 입니다.");
        }
    }
}
