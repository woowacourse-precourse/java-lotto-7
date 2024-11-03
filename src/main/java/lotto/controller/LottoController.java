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

    private final LottoService lottoService;

    public LottoController(){
        lottoService=new LottoService();
    }

    public void run(){
        OutputView.inputHowMuchBuy();
        String budget = InputView.input();
        lottoService.validateBudget(budget);
        LottoGame lottoGame = lottoService.constructLottoGame(budget);

        OutputView.outputHowManyBuy(lottoGame.getLottos().size());
        List<Lotto> lottos = lottoGame.getLottos();
        for (Lotto lotto : lottos) {
            OutputView.outputRandomLottoNumbers(lotto.getNumbers());
        }

        OutputView.inputLottoNumber();
        String lottoNumbers = InputView.input();
        OutputView.inputBonusNumber();
        String bonusNumber = InputView.input();

        lottoService.validateLottoNumbers(lottoNumbers, bonusNumber);
        Integer bonus = Parse.parseInteger(bonusNumber);
        CustomLotto customLotto = lottoService.constructCustomLotto(lottoNumbers, bonus);
        lottoGame.setCustomLotto(customLotto);


        lottoService.calculateLottoRank(lottoGame);
        BigDecimal profit = lottoService.calculateProfit(lottoGame);

        OutputView.outputResult();
        OutputView.outputResultOfWinning(lottoGame.getRank());
        OutputView.outputProfit(profit);
    }

}
