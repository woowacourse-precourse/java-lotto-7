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

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void startLottoGame() {
        LottoMachine lottoMachine = initializeLottoMachine();
        OutputView.printBoughtLotto(lottoMachine);

        Lotto winningLotto = initializeWinningLotto();
        BonusNumber bonusNumber = initializeBonusNumber();

        LottoResultManager lottoResultManager = calculateLottoResults(winningLotto, bonusNumber, lottoMachine);
        displayResults(lottoResultManager);
    }

    private LottoMachine initializeLottoMachine() {
        while (true) {
            try {
                return lottoService.generateLottoNumbers(InputView.inputPrice());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto initializeWinningLotto() {
        while (true) {
            try {
                return lottoService.initializeWinningLotto(InputView.inputWinningNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusNumber initializeBonusNumber() {
        while (true) {
            try {
                return lottoService.initializeBonusNumber(InputView.inputBonusNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private LottoResultManager calculateLottoResults(Lotto winningLotto, BonusNumber bonusNumber, LottoMachine lottoMachine) {
        return lottoService.checkLottoResult(winningLotto, bonusNumber, lottoMachine);
    }

    private void displayResults(LottoResultManager lottoResultManager) {
        OutputView.printLottoResult();
        OutputView.printLottoProfit(lottoResultManager);
    }
}
