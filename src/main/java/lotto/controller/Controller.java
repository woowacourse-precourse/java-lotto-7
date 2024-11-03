package lotto.controller;

import lotto.Lotto;
import lotto.model.MakeLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Controller{
    public void run(){
        int amount = InputView.inputAmount();
        MakeLotto makeLotto = new MakeLotto();
        int quantity = makeLotto.splitAmount(amount);
        List<Lotto> lottoList = makeLotto.makeLottoList(quantity);
        OutputView.buyMessage(quantity);
        OutputView.printLottoList(lottoList);
        Lotto prizeNum = InputView.inputPrize();
        int bonusNum = InputView.inputBonus();
        OutputView.output(lottoList, prizeNum, bonusNum, amount);
    }
}