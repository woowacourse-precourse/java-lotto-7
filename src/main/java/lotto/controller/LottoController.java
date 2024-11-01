package lotto.controller;

import lotto.Lotto;
import lotto.enums.LottoRank;
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

        purchaseAmount = requestPurchaseAmount();
        numOfTickets = purchaseAmount / 1000;
        outputView.printNumOfTickets(numOfTickets);

        lottos = lottoService.getLottos(numOfTickets);
        outputView.printGeneratedLottos(lottos);

        winningNumbers = requestWinningNumbers();
        bonusNumber = requestBonusNumber();

        List<LottoRank> ranks = lottoService.getRanks(winningNumbers, bonusNumber);
        outputView.printResult(lottoService.getPrizeResult(ranks), lottoService.getProfitRateResult(ranks, purchaseAmount));
    }

    private int requestPurchaseAmount() {
        outputView.printPurchaseAmountRequest();
        return inputView.readPurchaseAmount();
    }

    private List<Integer> requestWinningNumbers() {
        outputView.printWinningNumbersRequest();
        return inputView.readWinningNumbers();
    }

    private int requestBonusNumber() {
        outputView.printBonusNumberRequest();
        return inputView.readBonusNumber();
    }
}
