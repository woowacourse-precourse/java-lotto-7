package lotto.controller;

import lotto.domain.InputMoney;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.service.LottoService;
import lotto.domain.Lottos;
import lotto.domain.BonusNumber;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        long userInputMoney = inputView.getUserInputMoney();
        InputMoney inputMoney = new InputMoney(userInputMoney);
        Lottos lottos = lottoService.buyLottos(inputMoney);
        outputView.displayBuyLottos(lottos);

        WinningNumbers winningNumbers = getWinningNumbers();
        BonusNumber bonusNumber = getBonusNumber();
        LottoResult lottoResult = lottoService.findAnswer(lottos, winningNumbers, bonusNumber,inputMoney);
        outputView.displayWinningResult(lottoResult);
    }

    private WinningNumbers getWinningNumbers() {
        String inputWinningNumbers = inputView.getWinningNumbers();
        return new WinningNumbers(inputWinningNumbers);
    }

    private BonusNumber getBonusNumber() {
        String inputBonusNumber = inputView.getBonusNumber();
        return new BonusNumber(inputBonusNumber);
    }
}
