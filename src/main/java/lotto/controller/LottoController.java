package lotto.controller;

import java.util.List;
import lotto.factory.LottoFactory;
import lotto.factory.WinningNumbersFactory;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.model.WinningStatistic;
import lotto.service.LottoFacade;
import lotto.util.InputSupplier;
import lotto.util.Parser;
import lotto.validator.ValidatorFacade;
import lotto.view.ViewFacade;

public class LottoController {
    private final ViewFacade viewFacade;
    private final LottoFacade lottoFacade;
    private final ValidatorFacade validatorFacade;

    public LottoController(ViewFacade viewFacade, LottoFacade lottoFacade, ValidatorFacade validatorFacade) {
        this.viewFacade = viewFacade;
        this.lottoFacade = lottoFacade;
        this.validatorFacade = validatorFacade;
    }

    public void run() {
        int cost = getValidatedInput(this::getValidatedCost);

        int purchaseAmount = Parser.parsePurchaseAmount(cost);

        Lottos lottos = lottoFacade.issueLottos(purchaseAmount);
        viewFacade.showLottos(purchaseAmount, lottos);

        WinningNumbers winningNumbers = getValidatedInput(this::getValidatedWinningNumbers);

        WinningNumbers winningNumbersWithBonusNumber = getValidatedInput(
                () -> getValidatedWinningNumbersWithBonusNumber(winningNumbers));

        WinningStatistic winningStatistic = lottoFacade.getStatistic(cost, lottos, winningNumbersWithBonusNumber);

        viewFacade.showWinningStatistics(winningStatistic);
    }

    private <T> T getValidatedInput(InputSupplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                viewFacade.showErrorMessage(e.getMessage());
            }
        }
    }

    private int getValidatedCost() {
        String costInput = viewFacade.getCost();
        validatorFacade.validateCostInput(costInput);
        int cost = Parser.parseToInt(costInput);
        validatorFacade.validateCost(cost);
        return cost;
    }

    private WinningNumbers getValidatedWinningNumbers() {
        String winningNumbersInput = viewFacade.getWinningNumbers();
        validatorFacade.validateNumbersInput(winningNumbersInput);

        List<Integer> numbers = Parser.parseWinningNumbers(winningNumbersInput);

        Lotto winningLotto = LottoFactory.creatLotto(numbers);
        return WinningNumbersFactory.createWinningNumbers(winningLotto);
    }

    private WinningNumbers getValidatedWinningNumbersWithBonusNumber(WinningNumbers winningNumbers) {
        String bonusNumberInput = viewFacade.getBonusNumber();
        validatorFacade.validateBonusNumberInput(bonusNumberInput);
        int bonusNumber = Parser.parseToInt(bonusNumberInput);
        return winningNumbers.createWithBonusNumber(winningNumbers, bonusNumber);
    }
}
