package lotto.controller;

import lotto.BonusNumber;
import lotto.Lotto;
import lotto.LottoDrawResult;
import lotto.LottoPurchaseDetails;
import lotto.constant.LottoGrade;
import lotto.util.InputHandler;
import lotto.util.LottoNumberGenerator;
import lotto.util.LottoResultAggregator;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private static boolean isPurchaseAmountInvalidate = true;
    private static boolean isWinningNumberInvalidate = true;
    private static boolean isBonusNumberInvalidate = true;
    private final InputHandler inputHandler;
    private final OutputView outputView;
    private final LottoPurchaseDetails lottoPurchaseDetails;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final LottoDrawResult lottoDrawResult;
    private final LottoResultAggregator lottoResultAggregator;

    public LottoController(InputHandler inputHandler, OutputView outputView,
                           LottoPurchaseDetails lottoPurchaseDetails, LottoNumberGenerator lottoNumberGenerator,
                           LottoDrawResult lottoDrawResult, LottoResultAggregator lottoResultAggregator) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
        this.lottoPurchaseDetails = lottoPurchaseDetails;
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.lottoDrawResult = lottoDrawResult;
        this.lottoResultAggregator = lottoResultAggregator;
    }

    public void run() {

        issueLottoTickets();

        outputView.displayNumberOfPurchases(lottoPurchaseDetails.getPurchaseAmount());

        outputView.showLottoTickets(lottoPurchaseDetails.getLottoTickets());

        issueWinningNumbers();

        issueBonusNumber();

        Map<LottoGrade, Integer> aggregatedLottoResults = lottoResultAggregator.aggregateLottoResults(lottoDrawResult, lottoPurchaseDetails, lottoPurchaseDetails.getPurchaseAmount());

        outputView.announceLottoResults(aggregatedLottoResults, lottoPurchaseDetails.getPurchaseAmount());

    }

    private void issueLottoTickets() {
        while (isPurchaseAmountInvalidate) {
            try {
                String purchaseAmount = inputHandler.receivePurchaseAmount();

                inputHandler.validateInputPurchaseAmount(purchaseAmount);

                int parsedPurchaseAmount = inputHandler.parseInputNumber(purchaseAmount);

                List<List<Integer>> generatedLottoNumbers = lottoNumberGenerator.generateLottoNumbers(parsedPurchaseAmount);

                lottoPurchaseDetails.assignPurchaseAmount(parsedPurchaseAmount);

                lottoPurchaseDetails.assignIssuedLottoTickets(generatedLottoNumbers);

                updateIsPurchaseAmountInvalidate();

            } catch (IllegalArgumentException invalidInputNumberException) {
                System.out.println(invalidInputNumberException.getMessage());
            }
        }
    }

    private void issueWinningNumbers() {
        while (isWinningNumberInvalidate) {
            try {
                String winningNumbers = inputHandler.receiveWinningNumbers();

                inputHandler.validateWinningNumbers(winningNumbers);

                Lotto generatorWinningNumbers = lottoNumberGenerator.createWinningNumbers(winningNumbers);

                lottoDrawResult.assignWinningNumber(generatorWinningNumbers);

                updateIsWinningNumberInvalidate();
            } catch (IllegalArgumentException invalidWinningNumberException) {
                System.out.println(invalidWinningNumberException.getMessage());
            }
        }
    }

    private void issueBonusNumber() {
        while (isBonusNumberInvalidate) {
            try {
                String bonusNumber = inputHandler.receiveBonusNumber();

                inputHandler.validateBonusNumber(bonusNumber);

                BonusNumber generatedBonusNumber = lottoNumberGenerator.createBonusNumber(bonusNumber, lottoDrawResult.getWinningLotto());

                lottoDrawResult.assignBonusNumber(generatedBonusNumber);

                updateIsBonusNumberInvalidate();
            } catch (IllegalArgumentException invalidBonusNumberException) {
                System.out.println(invalidBonusNumberException.getMessage());
            }
        }
    }


    private void updateIsPurchaseAmountInvalidate() {
        isPurchaseAmountInvalidate = false;
    }

    private void updateIsWinningNumberInvalidate() {
        isWinningNumberInvalidate = false;
    }

    private void updateIsBonusNumberInvalidate() {
        isBonusNumberInvalidate = false;
    }

}


