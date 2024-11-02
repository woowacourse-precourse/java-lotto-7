package lotto.controller;

import java.util.List;
import lotto.model.lotto.Lottos;
import lotto.model.parseLotto.ParseLotto;
import lotto.view.InputView;
import lotto.view.OutView;

public class LottoController {

    private String winNumbersStr;

    private Integer buyAmount;
    private List<String> winNumbers;
    private Integer bonusNumber;

    public void run() {

        //입출력 로직
        buyAmount = InputView.inputBuyAmount();
        winNumbersStr = InputView.inputWinNumbers();
        bonusNumber = InputView.inputBonusNumber();
        winNumbers = ParseLotto.splitWinNumber(winNumbersStr);

        //로또 발행
        Lottos lottos = new Lottos(winNumbers, buyAmount, bonusNumber);
        lottos.generateLotto();
        lottos.lottosSort();

        //발행한 로또 출력
        OutView.generatedLottoPrint(lottos.getLottosCount(), lottos);

        lottos.getWinstatus().checkWin(lottos);

        OutView.winStatusPrint(lottos);

        lottos.calculateProfitRate();

    }

}
