package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.util.InputParser;
import lotto.validator.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.List;
import java.util.function.Supplier;

public class LottoController {
    private final LottoService lottoService;
    private final LottoValidator validator = new LottoValidator();

    public LottoController() {
        this.lottoService = new LottoServiceImpl();
    }

    public void startLotto() {
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> lottos = lottoService.generateLottos(purchaseAmount);
        OutputView.printLottoNumbers(lottos);

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();

        int[] winningCounts = lottoService.getWinningCount(lottos, winningNumbers, bonusNumber);
        double profitRate = lottoService.calculateProfitRate(winningCounts, purchaseAmount);

        OutputView.printLottoResult(winningCounts, profitRate);
    }

    private int getPurchaseAmount() {
        return getValidatedInput(() -> {
            int amount = InputParser.parsePurchaseAmount(InputView.getLottoPurchaseAmount());
            validator.validatePurchaseAmount(amount);
            return amount;
        });
    }

    private List<Integer> getWinningNumbers() {
        return getValidatedInput(() -> {
            List<Integer> numbers = InputParser.parseWinningNumbers(InputView.getWinningNumbers());
            validator.validateLottoNumbers(numbers);
            return numbers;
        });
    }

    private int getBonusNumber() {
        return getValidatedInput(() -> {
            int number = InputParser.parseBonusNumber(InputView.getBonusNumber());
            validator.validateBonusNumber(number);
            return number;
        });
    }

    private <T> T getValidatedInput(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}
