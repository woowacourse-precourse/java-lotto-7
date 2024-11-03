package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.PriceToBuyLottoException;
import lotto.model.PriceToBuyLotto;

import static lotto.common.constant.ErrorMessage.*;

public class InputView {

    public static PriceToBuyLotto getPriceToBuyLotto() {

        PriceToBuyLotto priceToBuyLotto;
        try {
            String userInputPriceToBuyLotto = Console.readLine();
            priceToBuyLotto = PriceToBuyLotto.of(userInputPriceToBuyLotto);
        } catch(PriceToBuyLottoException e){
            e.printErrorMessage();
            priceToBuyLotto = getPriceToBuyLotto();
        }finally{
            Console.close();
        }
        return priceToBuyLotto;
    }
}
