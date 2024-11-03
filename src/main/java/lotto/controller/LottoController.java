package lotto.controller;

import lotto.domain.lotto.IssuedLotto;
import lotto.domain.lotto.Rank;
import lotto.domain.purchase.PurchaseAmount;
import lotto.domain.winning.BonusNumber;
import lotto.domain.winning.WinningCombination;
import lotto.domain.winning.WinningNumbers;
import lotto.service.LottoService;
import lotto.validator.WinningValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
        lottoService = new LottoService();
    }

    public void startLottoGame() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();
        IssuedLotto issuedLotto = new IssuedLotto(lottoService.generateLottoTickets(purchaseAmount));
        printTicketCount(purchaseAmount);
        printLottoNumber(issuedLotto);

        WinningNumbers winningNumbers = readWinningNumbers();
        BonusNumber bonusNumber = readBonusNumber(winningNumbers.getWinningNumbers());
        WinningCombination winningCombination = new WinningCombination(winningNumbers, bonusNumber);

        List<Rank> ranks = lottoService.checkWinning(issuedLotto, winningCombination);
        Map<Rank, Long> rankCount = issuedLotto.calculateResults(winningCombination);

        printResult(rankCount);
        printProfitRate(lottoService.calculateProfitRate(ranks, purchaseAmount));
    }

    private PurchaseAmount readPurchaseAmount() {
        try {
            return new PurchaseAmount(inputView.readPurchaseAmount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readPurchaseAmount();
        }
    }

    private WinningNumbers readWinningNumbers() {
        String input = inputView.readWinningNumber();

        try {
            return new WinningNumbers(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readWinningNumbers();
        }
    }

    private BonusNumber readBonusNumber(List<Integer> winningNumbers) {
        String input = inputView.readBonusNumber();
        try {
            BonusNumber bonusNumber = new BonusNumber(input);
            WinningValidator.validateBonusNumberIsDuplicate(winningNumbers, bonusNumber.getBonusNumber());
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBonusNumber(winningNumbers);
        }
    }

    private void printTicketCount(PurchaseAmount purchaseAmount) {
        outputView.printLottoCount(purchaseAmount.calculateIssuedTicketCount());
    }

    private void printLottoNumber(IssuedLotto issuedLotto) {
        outputView.printLottoNumber(issuedLotto.getLottoTickets());
    }

    private void printResult(Map<Rank, Long> rankCount) {
        outputView.printWinningStatistics();
        outputView.printResult(rankCount);
    }

    private void printProfitRate(double profitRate) {
        outputView.printProfitRate(profitRate);
    }
}
