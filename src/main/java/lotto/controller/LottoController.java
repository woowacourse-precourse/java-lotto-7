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
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.domain.WinningNumber;
import lotto.model.LottoCollection;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.NoSuchElementException;

public class LottoController {
    private final OutputView outputView;
    private final InputView inputView;
    private LottoService lottoService;

    public LottoController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void buyLotto() {
        PurchaseAmount purchaseAmount = null;
        WinningNumber winningNumber = null;
        WinningLotto winningLotto = null;
        LottoCollection lottoCollection = null;

        purchaseAmount = getPurchaseAmount();
        printNumberOfLottoPurchases(purchaseAmount);
        lottoCollection = getLottoCollection(purchaseAmount);
        String state = lottoCollection.getState();
        printLottoCollectionState(state);
        winningNumber = getWinningNumber();
        winningLotto = getWinningLotto(winningNumber);
        lottoService = new LottoService(purchaseAmount, lottoCollection, winningLotto);
        judgeLotto();
        printWinningResult();
    }

    private void printLottoCollectionState(String state) {
        outputView.printLottoState(state);
    }

    private void printNumberOfLottoPurchases(PurchaseAmount purchaseAmount) {
        int numberOfLotto = purchaseAmount.getNumberOfLotto();
        outputView.printPurchaseAmount(numberOfLotto);
    }

    private WinningLotto getWinningLotto(WinningNumber winningNumber) {
        WinningLotto winningLotto;
        Bonus bonus = readBouns();
        winningLotto = getWinningLotto(winningNumber, bonus);
        return winningLotto;
    }

    private WinningNumber getWinningNumber() {
        WinningNumber winningNumber;
        winningNumber = readWinningNumber();
        return winningNumber;
    }

    private PurchaseAmount getPurchaseAmount() {
        PurchaseAmount purchaseAmount;
        try {
            purchaseAmount = readPurchaseAmount();
            return purchaseAmount;
        }catch (NoSuchElementException e) {
            purchaseAmount = readPurchaseAmount();
            return purchaseAmount;
        }
    }

    private  WinningLotto getWinningLotto(WinningNumber winningNumber, Bonus bonus) {
        if(bonus == null) {
            return null;
        }
        try {
            return new WinningLotto(winningNumber, bonus);
        }catch (Exception e) {
            outputView.printExceptionMessage(e.getMessage());
        }
        return null;
    }

    private LottoCollection getLottoCollection(PurchaseAmount purchaseAmount) {
        int numberOfLotto = purchaseAmount.getNumberOfLotto();
        return lottoIssuance(numberOfLotto);
    }

    private void printWinningResult() {
        int[] winningResult = lottoService.getWinningResult();
        outputView.printWinningResult(winningResult);
        double rateOfReturn = lottoService.getRateOfReturn();
        outputView.printRateOfReturn(rateOfReturn);
    }

    private void judgeLotto() {
        lottoService.judgeLotto();
    }

    private LottoCollection lottoIssuance(int numberOfLotto) {
        return new LottoCollection(numberOfLotto);
    }

    private Bonus readBouns() {
        try {
            outputView.printReadBonusNumber();
            String bonusNumber = inputView.readLine();
            return new Bonus(bonusNumber);
        }catch (Exception e) {
            outputView.printExceptionMessage(e.getMessage());
        }
        return null;
    }

    private WinningNumber readWinningNumber() {
        try {
            outputView.printReadWinningNumber();
            String winningNumber = inputView.readLine();
            return new WinningNumber(winningNumber);
        } catch (Exception e) {
            outputView.printExceptionMessage(e.getMessage());
        }
        return null;
    }


    private PurchaseAmount readPurchaseAmount() {
        double readLint;
        try {
            outputView.printReadPurchaseAmount();
            readLint = inputView.readDouble();
            return new PurchaseAmount(readLint);
        }catch (Exception e) {
            if (e instanceof NoSuchElementException) {
                throw (NoSuchElementException) e;
            }
            outputView.printExceptionMessage(e.getMessage());
            readPurchaseAmount();
        }
        return null;
    }
}
