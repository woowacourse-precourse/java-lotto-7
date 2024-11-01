package lotto.controller;

import lotto.Lotto;
import lotto.model.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    InputView inputView;
    OutputView outputView;
    LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void start() {
        int purchaseAmount, numOfTickets;
        List<Lotto> lottos;
        List<Integer> winningNumbers;
        int bonusNumber;

        outputView.printPurchaseAmountRequest();
        purchaseAmount = inputView.readPurchaseAmount();
        numOfTickets = purchaseAmount / 1000;
        outputView.printNumOfTickets(numOfTickets);

        lottos = lottoService.getLottos(numOfTickets);
        outputView.printGeneratedLottos(lottos);

        outputView.printWinningNumbersRequest();
        winningNumbers = inputView.readWinningNumbers();

        outputView.printBonusNumberRequest();
        bonusNumber = inputView.readBonusNumber();

        outputView.printResult(lottoService.getResult(winningNumbers, bonusNumber), purchaseAmount);
    }
}
