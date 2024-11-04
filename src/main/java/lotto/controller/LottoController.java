package lotto.controller;

import lotto.model.Lotto;
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
        int purchaseAmount, numOfTickets, bonusNumber;
        List<Lotto> lottos;
        List<Integer> winningNumbers;

        purchaseAmount = requestPurchaseAmount();

        numOfTickets = purchaseAmount / 1000;
        outputView.printNumOfTickets(numOfTickets);

        lottos = lottoService.getLottos(numOfTickets);
        outputView.printGeneratedLottos(lottos);

        winningNumbers = requestWinningNumbers();
        bonusNumber = requestBonusNumber();

        List<LottoRank> ranks = lottoService.getRanks(lottos, winningNumbers, bonusNumber);
        outputView.printResult(lottoService.getPrizeResult(ranks), lottoService.getProfitRateResult(ranks, purchaseAmount));
    }

    private int requestPurchaseAmount() {
        try {
            outputView.printPurchaseAmountRequest();
            return inputView.readPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestPurchaseAmount();
        }
    }

    private List<Integer> requestWinningNumbers() {
        try {
            outputView.printWinningNumbersRequest();
            return inputView.readWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestWinningNumbers();
        }
    }

    private int requestBonusNumber() {
        try {
            outputView.printBonusNumberRequest();
            return inputView.readBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestBonusNumber();
        }
    }
}
