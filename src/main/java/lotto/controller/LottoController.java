package lotto.controller;

import java.util.List;
import lotto.model.lotto.Lottos;
import lotto.model.parseLotto.ParseLotto;
import lotto.view.InputView;

public class LottoController {

    private String winNumbersStr;

    private Integer buyAmount;
    private List<String> winNumbers;
    private Integer bonusNumber;

    public void run(){
        buyAmount = InputView.inputBuyAmount();
        winNumbersStr = InputView.inputWinNumbers();
        bonusNumber = InputView.inputBonusNumber();

        winNumbers = ParseLotto.splitWinNumber(winNumbersStr);

        Lottos lottos = new Lottos(winNumbers, buyAmount);
        lottos.generateLotto();

    }

}
