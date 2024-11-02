package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Application;
import lotto.model.Lotto;
import lotto.view.ViewInput;

import java.util.List;

public class ApplicationController {
    private final ViewInput viewInput;

    public ApplicationController(ViewInput viewInput) {
        this.viewInput = viewInput;
    }


    public void run(){
        int purchaseAmount = viewInput.receivePurchaseAmount();
        for(int i = 0; i < purchaseAmount; i++){
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumber);
            lotto.printLottoNumbers(lottoNumber);
        }
        viewInput.receiveWinningNumber();
        viewInput.receiveLuckyNumber();
    }



}
