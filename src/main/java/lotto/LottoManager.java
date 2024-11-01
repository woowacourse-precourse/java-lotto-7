package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoManager {
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public static void run() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        int purchaseAmount = Integer.parseInt(Console.readLine());
    }
}
