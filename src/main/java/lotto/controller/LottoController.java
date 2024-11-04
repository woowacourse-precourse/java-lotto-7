package lotto.controller;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoPurchasePrice;
import lotto.model.LottoResult;
import lotto.model.LottoTicketCount;
import lotto.model.ReturnRate;
import lotto.model.WinningNumbers;
import lotto.service.LottoService;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchasePriceValidator;
import lotto.validator.WinningNumbersValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final PurchasePriceValidator purchasePriceValidator;
    private final WinningNumbersValidator winningNumbersValidator;
    private final BonusNumberValidator bonusNumberValidator;
    private final LottoService lottoService;

    public LottoController(PurchasePriceValidator purchasePriceValidator,
                           WinningNumbersValidator winningNumbersValidator,
                           BonusNumberValidator bonusNumberValidator,
                           LottoService lottoService) {
        this.purchasePriceValidator = purchasePriceValidator;
        this.winningNumbersValidator = winningNumbersValidator;
        this.bonusNumberValidator = bonusNumberValidator;
        this.lottoService = lottoService;
    }

    public void run() {
        LottoPurchasePrice lottoPurchasePrice = getLottoPurchasePrice();
        LottoTicketCount lottoTicketCount = getLottoTicketCount(lottoPurchasePrice);
        List<Lotto> lottos = getLottos(lottoTicketCount);
        WinningNumbers winningNumbers = getWinningNumbers();
        BonusNumber bonusNumber = getBonusNumber(winningNumbers.numbers());
        LottoResult lottoResult = getLottoResult(lottos, winningNumbers, bonusNumber);
        printReturnRate(lottoResult, lottoPurchasePrice);
    }

    private LottoPurchasePrice getLottoPurchasePrice() {
        while (true) {
            try {
                OutputView.printInputPurchasePrice();
                String inputPurchasePrice = InputView.readLine();
                purchasePriceValidator.validate(inputPurchasePrice);
                return lottoService.getLottoPurchasePrice(inputPurchasePrice);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private LottoTicketCount getLottoTicketCount(LottoPurchasePrice lottoPurchasePrice) {
        LottoTicketCount lottoTicketCount = lottoService.getLottoTicketCount(lottoPurchasePrice);
        OutputView.printLottoTicketCounts(lottoTicketCount.ticketCount());
        return lottoTicketCount;
    }

    private List<Lotto> getLottos(LottoTicketCount lottoTicketCount) {
        List<Lotto> lottos = lottoService.getLottos(lottoTicketCount);
        for (Lotto lotto : lottos) {
            OutputView.printLotto(lotto);
        }
        return lottos;
    }

    private WinningNumbers getWinningNumbers() {
        while (true) {
            try {
                OutputView.printInputWinningNumbers();
                String inputWinningNumbers = InputView.readLine();
                winningNumbersValidator.validate(inputWinningNumbers);
                return lottoService.getWinningNumbers(inputWinningNumbers);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private BonusNumber getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                OutputView.printInputBonusNumber();
                String inputBonusNumber = InputView.readLine();
                bonusNumberValidator.validate(inputBonusNumber, winningNumbers);
                return lottoService.getBonusNumber(inputBonusNumber);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private LottoResult getLottoResult(List<Lotto> lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        LottoResult lottoResult = lottoService.getLottoResult(lottos, winningNumbers, bonusNumber);
        OutputView.printStatistics(lottoResult);
        return lottoResult;
    }

    private void printReturnRate(LottoResult lottoResult, LottoPurchasePrice lottoPurchasePrice) {
        ReturnRate returnRate = lottoService.getReturnRate(lottoResult, lottoPurchasePrice);
        OutputView.printReturnRate(returnRate.returnRate());
    }
}
