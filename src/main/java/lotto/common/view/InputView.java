package lotto.common.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.model.PriceToBuyLotto;

import static lotto.common.constant.ErrorMessage.*;

public class InputView {

    public static PriceToBuyLotto getPriceToBuyLotto() {

        PriceToBuyLotto priceToBuyLotto;
        try {
            String userInputPriceToBuyLotto = Console.readLine();
            priceToBuyLotto = PriceToBuyLotto.of(userInputPriceToBuyLotto);
        } catch (NumberFormatException e) {
            PRICE_SHOULD_BE_INTEGER.printErrorMessage();
            priceToBuyLotto = getPriceToBuyLotto();
        }finally{
            Console.close();
        }
        return priceToBuyLotto;
    }
}
