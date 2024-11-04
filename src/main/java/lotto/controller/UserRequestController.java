package lotto.controller;

import lotto.sevice.InputValidService;

import static lotto.view.UserResponseView.*;

public class UserRequestController {
    InputValidService inputValidService = new InputValidService();

    public void inputMoney(String money){
        if(inputValidService.isMoney(money)){

            return;
        }
        error("로또 구입 금액이 잘 못 입력되었습니다.");
    }

    public void error(String detail){
        errorMessage(detail);
    }
}
