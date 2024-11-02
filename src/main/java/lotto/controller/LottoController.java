package lotto.controller;

import lotto.domain.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        getMoneyAndBuyLotto();
    }

    public void getMoneyAndBuyLotto(){
        try{
            outputView.showHowMuchMoneyToBuyLotto();
            int moneyForLotto = inputView.getLottoBuyMoney();
            LottoGenerator lottoGenerator = LottoGenerator.of(moneyForLotto);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            getMoneyAndBuyLotto();
        }
    }
}
