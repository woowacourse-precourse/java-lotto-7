package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String amount_message = "구입금액을 입력해 주세요."

    public static String inputAmount() {
        System.out.println(amount_message);
        return Console.readLine();
    }
}