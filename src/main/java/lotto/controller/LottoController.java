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
        int purchaseAmount = 0, numOfTickets = 0;
        List<Lotto> lottos;
        List<Integer> winningNumbers;
        int bonusNumber = 0;

        while(true) {
            try {
                purchaseAmount = requestPurchaseAmount();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        numOfTickets = purchaseAmount / 1000;
        outputView.printNumOfTickets(numOfTickets);

        lottos = lottoService.getLottos(numOfTickets);
        outputView.printGeneratedLottos(lottos);

        while (true) {
            try {
                winningNumbers = requestWinningNumbers();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                bonusNumber = requestBonusNumber();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

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
