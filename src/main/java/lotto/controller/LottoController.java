package lotto.controller;

import java.util.List;
import lotto.model.domain.BonusNumber;
import lotto.model.domain.LottoWinningNumbers;
import lotto.model.domain.Pocket;
import lotto.model.domain.UserStatus;
import lotto.model.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        List<Integer> winningLottoNumbers;
        BonusNumber bonusNumber;

        while (true) {
            try {
                buyLottoWithMoney();
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }

        while (true) {
            try {
                winningLottoNumbers = setWinningNumbers();
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }

        while (true) {
            try {
                bonusNumber = setWinningBonusNumber();
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }

        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningLottoNumbers, bonusNumber);

    }

    private void buyLottoWithMoney() {
        String inputMoney = InputView.requestMoney();
        int money = lottoService.moneyValidator(inputMoney);
        Pocket pocket = new Pocket(lottoService.activateLottoMachine(money));
        OutputView.printPurchasedLottoCount(pocket);
    }

    private List<Integer> setWinningNumbers() {
        String inputWinningNumbers = InputView.requestLottoWinningNumbers();
        return lottoService.winningNumbersGenerator(inputWinningNumbers);
    }

    private BonusNumber setWinningBonusNumber() {
        String inputBonusNumber = InputView.requestLottoBonusNumber();
        return lottoService.bonusNumberGenerator(inputBonusNumber);
    }
}