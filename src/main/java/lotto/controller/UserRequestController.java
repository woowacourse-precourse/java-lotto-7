package lotto.controller;

import lotto.sevice.InputValidService;
import lotto.sevice.LottoService;

import static lotto.view.UserResponseView.*;

public class UserRequestController {
    InputValidService inputValidService = new InputValidService();
    int lottoCnt;

    public void inputMoney(String money){
        if(inputValidService.isMoney(money)){
            lottoCnt = LottoService.countLotto(money);
            pickLotto();
            return;
        }
        error("로또 구입 금액이 잘 못 입력되었습니다.");
    }

    public void error(String detail){
        errorMessage(detail);
    }

    public void pickLotto(){
        countLottoMessage(lottoCnt);
    }
}
