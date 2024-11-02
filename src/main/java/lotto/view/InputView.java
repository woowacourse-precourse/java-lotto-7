package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요. (1000원 단위로 입력)");
        return Console.readLine();
    }

}
