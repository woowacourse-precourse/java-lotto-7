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

import lotto.constant.Constant;
import lotto.constant.ErrorMessage;
import lotto.domain.*;
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

        purchaseAmount = getAmount();
        lottoCollection = getLottoCollection(purchaseAmount);
        printCollectionState(lottoCollection);
        winningNumber = getWinningNumber();
        winningLotto = getWinningLotto(winningNumber);
        lottoService = new LottoService(lottoCollection, winningLotto);
        judgeLotto();
        printWinningResult();
    }

    private WinningLotto getWinningLotto(WinningNumber winningNumber) {
        WinningLotto winningLotto = null;
        Bonus bonus = null;
        do {
            do {
                bonus = readBouns();
            }while (bonus == null);
            try {
                winningLotto = getWinningLotto(winningNumber, bonus);
            }catch (Exception e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }while (winningLotto == null);
        return winningLotto;
    }

    private WinningNumber getWinningNumber() {
        WinningNumber winningNumber;
        do {
            winningNumber = readWinningNumber();
        }while (winningNumber == null);
        return winningNumber;
    }

    private LottoCollection getLottoCollection(PurchaseAmount purchaseAmount) {
        LottoCollection lottoCollection;
        lottoCollection = getCollection(purchaseAmount);
        return lottoCollection;
    }

    private PurchaseAmount getAmount() {
        PurchaseAmount purchaseAmount;
        do {
            purchaseAmount = getPurchaseAmount();
        }while (purchaseAmount == null);
        return purchaseAmount;
    }

    private void printCollectionState(LottoCollection lottoCollection) {
        String state = lottoCollection.getState();
        printLottoCollectionState(state);
    }

    private LottoCollection getCollection(PurchaseAmount purchaseAmount) {
        LottoCollection lottoCollection;
        printNumberOfLottoPurchases(purchaseAmount);
        int numberOfLotto = purchaseAmount.getNumberOfLotto();
        lottoCollection = new LottoCollection(numberOfLotto);
        return lottoCollection;
    }

    private void printLottoCollectionState(String state) {
        outputView.printLottoState(state);
    }

    private void printNumberOfLottoPurchases(PurchaseAmount purchaseAmount) {
        int numberOfLotto = purchaseAmount.getNumberOfLotto();
        if (numberOfLotto != Constant.ZERO) {
            outputView.printPurchaseAmount(numberOfLotto);
        }
    }

    private PurchaseAmount getPurchaseAmount() {
        PurchaseAmount purchaseAmount = null;
        try {
            purchaseAmount = readPurchaseAmount();
            return purchaseAmount;
        }catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
        }catch (NoSuchElementException e) {
            purchaseAmount = readPurchaseAmount();
        }
        return purchaseAmount;
    }

    private  WinningLotto getWinningLotto(WinningNumber winningNumber, Bonus bonus) {
        if(bonus == null) {
            return null;
        }
        try {
            return new WinningLotto(winningNumber, bonus);
        }catch (Exception e) {
            throw e;
        }
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
        double readLint = 0;
        try {
            outputView.printReadPurchaseAmount();
            readLint = inputView.readDouble();
        }catch (Exception e) {
            if (e instanceof NoSuchElementException) {
                throw (NoSuchElementException) e;
            }
            throw new IllegalArgumentException(ErrorMessage.READ_NUMBER_ERROR_MESSAGE);
        }
        return new PurchaseAmount(readLint);
    }
}
