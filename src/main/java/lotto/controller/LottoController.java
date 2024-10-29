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

        LottoMachine lottoMachine = getLottoMachine();
        OutputView.printBoughtLotto(lottoMachine);

        Lotto winningLotto = getLotto();

        BonusNumber bonusNumber = getNumber();

        LottoResultManager lottoResultManager = lottoService.checkLottoResult(winningLotto, bonusNumber, lottoMachine);
        OutputView.printLottoResult();

        OutputView.printLottoProfit(lottoResultManager);

    }

    private BonusNumber getNumber() {
        try {
            return lottoService.initializeBonusNumber(InputView.inputBonusNumber());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getNumber();
        }
    }

    private Lotto getLotto() {
        try {
            return lottoService.initializeWinningLotto(InputView.inputWinningNumbers());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getLotto();
        }
    }

    private LottoMachine getLottoMachine() {
        try {
            return lottoService.generateLottoNumbers(InputView.inputPrice());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getLottoMachine();
        }
    }


}
