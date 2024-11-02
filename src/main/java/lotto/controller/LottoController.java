package lotto.controller;

import lotto.model.*;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private User user;
    private LottoGame lottoGame;
    private LottoResult lottoResult;
    private LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run(){
        beforeLotto();
        startLotto();
        afterLotto();
    }

    private void beforeLotto(){
        initUser();
        buyLottos();
        initLottoGame();
    }

    private void initUser(){
        int buyAmount = InputView.inputBuyAmount();
        user = new User(buyAmount);
    }

    private void initLottoGame(){
        WinningNumbers winningNumbers = new WinningNumbers(InputView.inputWinningNumbers());
        BonusNumber bonusNumber = new BonusNumber(InputView.inputBonusNumber());
        lottoGame = new LottoGame(winningNumbers, bonusNumber);
    }

    private void buyLottos(){
        lottoService.buyLottos(user);
        OutputView.printBuyLottos(user);
    }

    private void startLotto(){
        lottoResult = lottoService.setLottoResult(lottoGame, user);
    }

    private void afterLotto(){
        OutputView.printLottoResult(lottoResult);
        double returnRate = lottoService.getReturnRate(user, lottoResult);
        OutputView.printReturnRate(returnRate);
    }

}
