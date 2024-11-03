package lotto.common.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.model.PriceToBuyLotto;

public class InputView {

    public static PriceToBuyLotto getPriceToBuyLotto() {
        String userInputPriceToBuyLotto = Console.readLine();
        return PriceToBuyLotto.of(userInputPriceToBuyLotto);
    }
}
