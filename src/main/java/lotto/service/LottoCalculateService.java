package lotto.service;

import static lotto.view.InputView.getPrintInputBonusNumberMessage;
import static lotto.view.InputView.getPrintInputPurchaseMessage;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionCode;

public class LottoCalculateService {

    public void inputMoney(){
        getPrintInputPurchaseMessage();
        LottoCreateService.createUserLotto(moneyCalculate(Console.readLine()));
    }

    public Integer moneyCalculate(String money){
        if (Integer.valueOf(money) % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_MONEY_PRICE.getMessage());
        }
        return Integer.valueOf(money) / 1000;
    }





}
