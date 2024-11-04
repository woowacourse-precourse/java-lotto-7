package lotto.controller;

import lotto.Lotto;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private final Lotto lotto;

    public LottoController(Lotto lotto) {
        this.lotto = lotto;
    }

    public void run(){
        String inputAmount = LottoView.inputAmount();
        List <Lotto> lottoList= purchaseLotto(Integer.parseInt(inputAmount));
        LottoView.printLottoList(lottoList);
    }

    private List<Lotto> purchaseLotto(Integer amount){
        List<Lotto> lottoList = new ArrayList<>();
        for(int i =0; i< amount; i++){
            lottoList.add(new Lotto(lotto.createLotto()));
        }
        return lottoList;
    }
}
