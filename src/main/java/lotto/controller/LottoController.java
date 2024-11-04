package lotto.controller;

import java.util.HashMap;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.enums.LottoRank;
import lotto.service.LottoService;
import lotto.util.InputUtil;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {
    private final LottoService lottoService;
    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;
    private int ticketCount;
    private PurchaseAmount purchaseAmount;
    private List<Lotto> totalLottoNumbers;
    private Lotto winningLottoNumbers;
    private BonusNumber winningBonusNumber;

    public LottoController() {
        this.lottoService = new LottoService();
        this.lottoInputView = new LottoInputView();
        this.lottoOutputView = new LottoOutputView();
    }

    public void playLottoGame() {
        purchaseLotto();
        makeWinningLotto();
        showLottoGameResult();
    }

    private void showLottoGameResult() {
        HashMap<LottoRank, Integer> winningResults = lottoService.getWinningResults(totalLottoNumbers,
                winningLottoNumbers, winningBonusNumber);
        for (int rank = 5; rank > 0; rank--) {
            LottoRank lottoRank = LottoRank.getEnumsValue(rank);
            lottoOutputView.printLottoResultMessage(lottoRank, winningResults.get(lottoRank));
        }
        double rateOfReturn = lottoService.calculateRateOfReturn(winningResults, purchaseAmount);
        lottoOutputView.printLottoRateOfReturnMessage(rateOfReturn);
    }

    private void makeWinningLotto() {
        makeLotto();
        makeBonusNumber();
    }

    private void makeBonusNumber() {
        boolean checkInput = false;

        while (!checkInput) {
            try {
                String inputBonusNumber = lottoInputView.readBonusNumberInput();
                winningBonusNumber = new BonusNumber(InputUtil.convertStringToInt(inputBonusNumber));
                checkInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void makeLotto() {
        boolean checkInput = false;

        while (!checkInput) {
            try {
                String inputLotto = lottoInputView.readLottoNumberInput();
                winningLottoNumbers = new Lotto(InputUtil.parseInputToLottoList(inputLotto));
                checkInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void purchaseLotto() {
        getPurchaseAmount();
        lottoOutputView.printPurchaseAmountMessage(ticketCount);
        totalLottoNumbers = lottoService.generateTotalLottoNumbers(ticketCount);
        lottoOutputView.printRandomLottoNumberMessage(totalLottoNumbers);
    }

    private void getPurchaseAmount() {
        boolean checkInput = false;

        while (!checkInput) {
            try {
                String inputCash = lottoInputView.readPurchaseAmountInput();
                int purchaseCash = InputUtil.convertStringToInt(inputCash);
                purchaseAmount = new PurchaseAmount(purchaseCash);
                ticketCount = lottoService.calculateLottoTickets(purchaseAmount);
                checkInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
