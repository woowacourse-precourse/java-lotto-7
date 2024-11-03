package lotto.controller;


import lotto.domain.CustomLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.service.LottoService;
import lotto.util.Parse;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.util.List;


public class LottoController {

    private final InputView inputView;
    private final LottoService lottoService;

    public LottoController(){
        inputView= new InputView();
        lottoService=new LottoService();
    }

    public void run(){
        OutputView.inputHowMuchBuy();
        String budget = inputView.input();
        lottoService.validateBudgetMoney(budget);
        LottoGame lottoGame = lottoService.constructLottoGame(budget);

        OutputView.outputHowManyBuy(lottoGame.getLottos().size());
        List<Lotto> lottos = lottoGame.getLottos();
        for (Lotto lotto : lottos) {
            OutputView.outputRandomLottoNumbers(lotto.getNumbers());
        }

        OutputView.inputLottoNumber();
        String lottoNumbers = inputView.input();
        OutputView.inputBonusNumber();
        String bonusNumber = inputView.input();

        lottoService.validateLottoNumbers(lottoNumbers, bonusNumber);
        Integer bonus = Parse.parseInteger(bonusNumber);
        CustomLotto customLotto = lottoService.makeCustomLotto(lottoNumbers, bonus);
        lottoGame.setCustomLotto(customLotto);

        lottoGame.calculateLottoRank();
        BigDecimal profit = lottoService.calculateProfit(lottoGame);

        OutputView.outputResult();
        OutputView.outputResultOfWinning(lottoGame.getRank());
        OutputView.outputProfit(profit);
    }

}
