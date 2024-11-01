package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoInputView {

    private static final String PRICE_REQUEST = "구입금액을 입력해 주세요.";

    public String getPriceInput() {
        System.out.println(PRICE_REQUEST);

        return Console.readLine();
    }
}
