package lotto.controller;

import lotto.model.RandomLotto;
import lotto.sevice.InputValidService;
import lotto.sevice.LottoService;

import java.util.List;

import static lotto.view.UserResponseView.*;

public class UserRequestController {
    InputValidService inputValidService = new InputValidService();
    LottoService lottoService = new LottoService();
    int lottoCnt;
    RandomLotto randomLotto;

    public void inputMoney(String money){
        if(inputValidService.isMoney(money)){
            lottoCnt = lottoService.countLotto(money);
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
        randomLotto = new RandomLotto(lottoCnt);
    }

    public void showRandomLotto(){
        List<List<Integer>> lotto = randomLotto.getLotto();
        for(List<Integer> ls : lotto){
            randomLottoMessage(ls);
        }
    }
}
