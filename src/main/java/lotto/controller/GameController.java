package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;
import lotto.view.InputView;

public class GameController {

    public Money getPurchaseMoney(){
        InputView.requestPurchaseMoney();
        return new Money(Integer.parseInt(Console.readLine()));
    }

}
