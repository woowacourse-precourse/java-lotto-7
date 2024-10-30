package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String LOTTO_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String LOTTO_CAST_LOTS_LOT_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String lottoPurchase() {
        System.out.println(LOTTO_PURCHASE_MESSAGE);
        return Console.readLine();
    }

    public String lottoCastLotsLot() {
        System.out.println(LOTTO_CAST_LOTS_LOT_MESSAGE);
        return Console.readLine();
    }

    public String bonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
