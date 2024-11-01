package lotto.controller;

import lotto.service.DecideQuantityOfLotto;
import lotto.service.GenerateLottoNumberManager;
import lotto.service.WinningManager;
import lotto.view.OutputView;
import java.util.List;
public class LottoController {
    OutputView outputView = new OutputView();
    WinningManager winning = new WinningManager();

    public void createLottoNumber(int price){
        int num = new DecideQuantityOfLotto().purchaseLottoTickets(price);
        List<List<Integer>> list = new GenerateLottoNumberManager().generate(num);
        outputView.result(list);
    }

    public void createWinningNumber(String s){
        winning.generateWinningNumber(s);
    }

    public void calculateCorrect(){

    }

}
