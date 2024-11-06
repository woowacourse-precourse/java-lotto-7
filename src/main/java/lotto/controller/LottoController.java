package lotto.controller;

import lotto.domain.LottoGenerator;
import lotto.domain.PurchaseAmount;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.WinningNumbers;
import lotto.dto.PurchasedLottosResponse;
import lotto.dto.WinningSummaryResponse;
import lotto.parser.LottoNumbersInputParser;
import lotto.view.ConsoleView;

import java.util.List;
import java.util.function.Supplier;

public class LottoController {
    private final ConsoleView consoleView;

    public LottoController(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }

    public void run() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();
        List<Lotto> purchasedLottos = generateLottos(purchaseAmount);
        consoleView.printPurchasedLottos(PurchasedLottosResponse.from(purchasedLottos));

        Lotto winningLotto = readWinningLottoNumbers();
        LottoNumber bonusNumber = readBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);

        WinningSummaryResponse winningSummary = winningNumbers.findWinningResult(purchasedLottos, purchaseAmount);
        consoleView.printWinningResult(winningSummary);
    }

    private PurchaseAmount readPurchaseAmount() {
        String purchaseAmountInput = consoleView.readPurchaseAmountInput();
        PurchaseAmount purchaseAmount = new PurchaseAmount(purchaseAmountInput);

        int lottoCount = purchaseAmount.calculatePurchasableLottoCount();
        consoleView.printPurchasableLottoCount(lottoCount);

        return purchaseAmount;
    }

    private List<Lotto> generateLottos(PurchaseAmount purchaseAmount) {
        LottoGenerator lottoGenerator = LottoGenerator.getInstance();

        return lottoGenerator.generateLottos(purchaseAmount.calculatePurchasableLottoCount());
    }

    private Lotto readWinningLottoNumbers() {
        String winningLottoNumbersInput = consoleView.readWinningLottoNumbersInput();
        LottoNumbersInputParser lottoNumbersInputParser = LottoNumbersInputParser.getInstance();
        List<Integer> lottoNumbers = lottoNumbersInputParser.parse(winningLottoNumbersInput);

        return new Lotto(lottoNumbers);
    }

    private LottoNumber readBonusNumber() {
        String bonusNumberInput = consoleView.readBonusNumberInput();

        return new LottoNumber(bonusNumberInput);
    }

    private <T> T readInput(Runnable prompt, Supplier<T> inputSupplier) {
        try {
            prompt.run();
            return inputSupplier.get();
        } catch (IllegalArgumentException exception) {
            consoleView.printException(exception);
            return readInput(prompt, inputSupplier);
        }
    }
}
