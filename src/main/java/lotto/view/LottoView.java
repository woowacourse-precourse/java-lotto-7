package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoView {
    private static final String LOTTO_PURCHASE_PRICE_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";


    public String requestLottoPurchasePrice(){
        System.out.println(LOTTO_PURCHASE_PRICE_REQUEST_MESSAGE);
        return input();
    }

    public String input(){
        return Console.readLine();
    }
}
