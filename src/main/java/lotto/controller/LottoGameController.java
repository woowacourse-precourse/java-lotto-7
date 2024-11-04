package lotto.controller;

import java.util.List;
import lotto.dto.LottoResult;
import lotto.model.Lotto;
import lotto.service.Converter;
import lotto.service.LottoResultService;
import lotto.service.LottoSeller;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final PurchaseAmountValidator purchaseAmountValidator;
    private final WinningNumberValidator winningNumberValidator;
    private final BonusNumberValidator bonusNumberValidator;
    private final LottoSeller lottoSeller;
    private LottoResultService lottoResultService;

    public LottoGameController() {
        this.purchaseAmountValidator = new PurchaseAmountValidator();
        this.winningNumberValidator = new WinningNumberValidator();
        this.bonusNumberValidator = new BonusNumberValidator();
        this.lottoSeller = new LottoSeller();
    }

    public void start() {
        int purchaseAmount = getPurchaseAmountAndValidate();
        displayLottoCount(purchaseAmount);
        List<Lotto> lotto = buyLottoAndDisplay(purchaseAmount);
        List<Integer> winningNumbers = getWinningNumbersAndValidate();
        int bonusNumber = getBonusNumberAndValidate(winningNumbers);
        getLottoResultAndDisplay(lotto, winningNumbers, bonusNumber);
    }

    private void getLottoResultAndDisplay(List<Lotto> lotto, List<Integer> winningNumbers, int bonusNumber) {
        LottoResult lottoResult = getLottoResult(lotto, winningNumbers, bonusNumber);
        OutputView.displayResult(lottoResult);
    }

    private List<Lotto> buyLottoAndDisplay(int purchaseAmount) {
        List<Lotto> lotto = lottoSeller.buyLotto(purchaseAmount);
        OutputView.displayPurchaseLotto(lotto);
        return lotto;
    }

    private void displayLottoCount(int purchaseAmount) {
        int lottoCount = lottoSeller.calculatePurchaseCount(purchaseAmount);
        OutputView.displayPurchaseCount(lottoCount);
    }

    private LottoResult getLottoResult(List<Lotto> lotto, List<Integer> winningNumbers, int bonusNumber) {
        lottoResultService = new LottoResultService(lotto, winningNumbers, bonusNumber);
        return lottoResultService.getLottoResult();
    }

    private int getPurchaseAmountAndValidate() {
        while (true) {
            try {
                String purchaseAmount = InputView.getLottoPurchaseAmount();
                purchaseAmountValidator.validate(purchaseAmount);
                return Converter.integerConvert(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> getWinningNumbersAndValidate() {
        while (true) {
            try {
                String winningNumbers = InputView.getWinningNumbers();
                winningNumberValidator.validate(winningNumbers);
                return Converter.winningNumbersConvert(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBonusNumberAndValidate(List<Integer> winningNumbers) {
        while (true) {
            try {
                String bonusNumber = InputView.getBonusNumber();
                bonusNumberValidator.validate(winningNumbers, bonusNumber);
                return Converter.integerConvert(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
