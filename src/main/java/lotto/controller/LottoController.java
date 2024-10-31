/*
 * 클래스 이름 LottoController
 *
 * 버전 정보 V1
 *
 * 날짜 10월 30일
 *
 * 저작권 주의
 */
package lotto.controller;

import lotto.domain.Bonus;
import lotto.domain.WinningNumber;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;
    private final InputView inputView;
    private final LottoService lottoService;

    public LottoController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
        lottoService = new LottoService();
    }

    public void byLotto() {
        readPurchaseAmount();
        lottoIssuance();
        printLottoPurchaseResult();
        WinningNumber winningNumber = readWinningNumber();
        Bonus bonus = readBouns();
        readWinningLotto(winningNumber, bonus);
        judgeLotto();
        printWinningResult();
    }

    private void printWinningResult() {
        int[] winningResult = lottoService.getWinningResult();
        outputView.printWinningResult(winningResult);
        double rateOfReturn = lottoService.getRateOfReturn();
        outputView.printRateOfReturn(rateOfReturn);
    }

    private void readWinningLotto(WinningNumber winningNumber, Bonus bonus) {
        lottoService.readWinningLotto(winningNumber, bonus);
    }

    private void judgeLotto() {
        lottoService.judgeLotto();
    }

    private void lottoIssuance() {
        lottoService.lottoIssuance();
    }

    private Bonus readBouns() {
        outputView.printReadBonusNumber();
        String bonusNumber = inputView.readLine();
        return new Bonus(bonusNumber);
    }

    private WinningNumber readWinningNumber() {
        outputView.printReadWinningNumber();
        String winningNumber = inputView.readLine();
        return new WinningNumber(winningNumber);
    }

    private void printLottoPurchaseResult() {
        String state = lottoService.getLottoPurchaseResult();
        outputView.printLottoState(state);
    }

    private void readPurchaseAmount() {
        outputView.printReadPurchaseAmount();
        String readLine = inputView.readLine();
        try {
            lottoService.readPurchaseAmount(readLine);
        }catch (Exception e) {
            outputView.printExceptionMessage(e.getMessage());
        }
    }
}
