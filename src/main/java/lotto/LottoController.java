package lotto;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import lotto.view.PrintOutputView;
import lotto.view.ReadUserInputView;

public class LottoController {
    private final ReadUserInputView inputView;
    private final PrintOutputView outputView;
    private final LottoService lottoService;

    public LottoController(ReadUserInputView inputView, PrintOutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void startLotto() {
        Supplier<PurchaseAmount> purchaseAmountSupplier = this::readPurchaseAmount;
        PurchaseAmount purchaseAmount = repeatReadInput(purchaseAmountSupplier);

        printRandomLottos(purchaseAmount.getPurchaseAmount(),
                lottoService.generateRandomNumberLottos(purchaseAmount.getPurchaseAmount()));

        Supplier<WinningNumbers> purchaseWinningNumbers = this::readWinningNumbers;
        WinningNumbers winningNumbers = repeatReadInput(purchaseWinningNumbers);

        BonusNumber bonusNumber = readBonusNumber(winningNumbers);
        printLottoResult(lottoService.calculateResult(winningNumbers, bonusNumber), purchaseAmount);
    }

    private PurchaseAmount readPurchaseAmount() {
        return new PurchaseAmount(requirePurchaseAmount());
    }

    private int requirePurchaseAmount() {
        outputView.printRequirePurchaseAmount();
        return inputView.readPurchaseAmount();
    }

    private WinningNumbers readWinningNumbers() {
        return new WinningNumbers(requireWinningNumbers());
    }

    private List<Integer> requireWinningNumbers() {
        outputView.printRequireWinningNumbers();
        return inputView.readWinningNumbers();
    }

    private BonusNumber readBonusNumber(WinningNumbers winningNumbers) {
        Function<WinningNumbers, BonusNumber> requireBonusNumber = this::requireBonusNumber;
        return repeatReadInput(() -> requireBonusNumber.apply(winningNumbers));
    }

    private BonusNumber requireBonusNumber(WinningNumbers winningNumbers) {
        outputView.printRequireBonusNumber();
        BonusNumber bonusNumber = new BonusNumber(inputView.readBonusNumber());
        bonusNumber.validateBonusNumberInRange();
        bonusNumber.validateBonusNumberNotDuplicate(winningNumbers);
        return bonusNumber;
    }

    private void printRandomLottos(int purchaseAmount, String randomLottos) {
        outputView.printPurchaseAmount(purchaseAmount);
        outputView.printRandomLottoNumbers(randomLottos);
    }

    private void printLottoResult(LottoResult lottoResult, PurchaseAmount purchaseAmount) {
        outputView.printLottoResult(lottoResult.printTotalWinningCount(),
                lottoResult.calculateEarningRate(purchaseAmount.getPurchasePrice()));
    }

    private <T> T repeatReadInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
