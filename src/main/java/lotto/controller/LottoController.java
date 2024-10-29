package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoResultManager;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService){
        this.lottoService = lottoService;
    }

    public void startLottoGame(){

        LottoMachine lottoMachine = lottoService.generateLottoNumbers(getPrice());
        OutputView.printBoughtLotto(lottoMachine);

        Lotto winningLotto = lottoService.initializeWinningLotto(getWinningLotto());

        BonusNumber bonusNumber = lottoService.initializeBonusNumber(getBonusNumber());

        LottoResultManager lottoResultManager = lottoService.checkLottoResult(winningLotto, bonusNumber, lottoMachine);
        OutputView.printLottoResult();

        OutputView.printLottoProfit(lottoResultManager);

    }


    private static String getWinningLotto() {
        try {
            return InputView.inputWinningNumbers();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getWinningLotto();
        }
    }

    private static String getBonusNumber() {
        try {
            return InputView.inputBonusNumber();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getBonusNumber();
        }
    }

    private static String getPrice() {
        try {
            return InputView.inputPrice();
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPrice();
        }
    }

}
