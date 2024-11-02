package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoTicket;
import lotto.model.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
    }

    public void run() {
        while (true) {
            try {
                int purchaseAmount = inputPurchaseAmount();
                LottoTicket lottoTicket = handleLottoPurchase(purchaseAmount);  // LottoTicket 사용
                WinningNumbers winningNumbers = inputWinningNumbers();
                LottoResult result = calculateAndDisplayResults(lottoTicket.getLottoList(), winningNumbers);
                displayTotalProfitRate(purchaseAmount, result);
                break;
            } catch (IllegalArgumentException | IllegalStateException e) {
                outputView.displayError("[ERROR] " + e.getMessage());
            }
        }
    }

    private int inputPurchaseAmount() {
        while (true) {
            try {
                return inputView.readPurchaseAmount();
            } catch (IllegalArgumentException e) {
                outputView.displayError("[ERROR] " + e.getMessage());
            }
        }
    }

    private LottoTicket handleLottoPurchase(int purchaseAmount) {
        List<Lotto> purchasedLottos = lottoService.purchaseLottos(purchaseAmount);
        LottoTicket lottoTicket = new LottoTicket(new ArrayList<>()); // 빈 리스트로 LottoTicket 생성

        for (Lotto lotto : purchasedLottos) {
            lottoTicket.addLotto(lotto); // 구매한 로또를 LottoTicket에 추가
        }

        outputView.printLottoNumbers(purchasedLottos.size(), purchasedLottos);
        return lottoTicket;
    }


    private WinningNumbers inputWinningNumbers() {
        while (true) {
            try {
                return inputView.readWinningNumbers();
            } catch (IllegalArgumentException e) {
                outputView.displayError(e.getMessage());
            }
        }
    }

    private LottoResult calculateAndDisplayResults(List<Lotto> purchasedLottos, WinningNumbers winningNumbers) {
        LottoResult result = lottoService.calculateResult(purchasedLottos, winningNumbers);
        outputView.printLottoResults(result);
        return result;
    }

    private void displayTotalProfitRate(int purchaseAmount, LottoResult result) {
        double totalProfitRate = lottoService.calculateProfitRate(purchaseAmount, result.calculateTotalPrize());
        outputView.printTotalProfitRate(totalProfitRate);
    }
}
