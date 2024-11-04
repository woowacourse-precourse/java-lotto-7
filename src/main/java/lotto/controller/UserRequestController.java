package lotto.controller;

import lotto.model.Lotto;
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
    Lotto lotto;
    static int bonusNumber;

    public void inputMoney(String money){
        if(inputValidService.isMoney(money)){
            lottoCnt = lottoService.countLotto(money);
            pickLotto();
            showRandomLotto();
            return;
        }
        error("로또 구입 금액이 잘 못 입력되었습니다.");
    }

    public void inputWinNumbers(String numbers){
        if(inputValidService.isWinNumbers(numbers)){
            lotto = new Lotto(lottoService.getWinLottoList(numbers));
            return;
        }
        error("로또 번호 입력이 잘 못 되었습니다.");
    }

    public void inputBonusNum(String bonusNum){
        if(inputValidService.isBonusNumber(bonusNum)){
            bonusNumber = Integer.parseInt(bonusNum);
            return;
        }
        error("로또 보너스 번호의 입력이 잘 못 되었습니다.");
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
        System.out.println();
    }
}
