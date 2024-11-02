package lotto.view;

import lotto.domain.User;
import static lotto.message.LottoMessage.DISPLAY_LOTTO_COUNT;

public class InputView {

    public static void displayLottoPurchaseAmount(User user) {
        System.out.printf(DISPLAY_LOTTO_COUNT.getMessage(), user.getNumOfLottos());
    }
}
