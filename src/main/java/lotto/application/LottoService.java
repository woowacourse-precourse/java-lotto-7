package lotto.application;

import lotto.model.Lottoes;
import lotto.model.PriceToBuyLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService implements Service{

    @Override
    public void buyLottoHandler(){
        //input
        OutputView.printPromptMessageForPriceToBuyLotto();
        PriceToBuyLotto priceToBuyLotto = InputView.getPriceToBuyLotto();

        //generate Lotto
        Lottoes lottoes = new Lottoes(priceToBuyLotto);

        //output
        OutputView.printNumberOfLotto(lottoes.getLottoesCount());
        lottoes.printLottoesInfo();
    }

    @Override
    public void matchLottoHandler(){

    }

}
