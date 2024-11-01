package lotto;

import lotto.model.Budget;
import lotto.model.Lottos;
import lotto.util.BudgetValidator;
import lotto.view.ErrorView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
    final InputView inputView;
    final OutputView outputView;
    final ErrorView errorView;

    public LottoApplication(InputView inputView, OutputView outputView, ErrorView errorView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.errorView = errorView;
    }

    public void run() {
        Budget budget = getValidatedBudget();
        Lottos lottos = Lottos.from(budget);
        outputView.printLottos(lottos);
    }

    private Budget getValidatedBudget() {
        while (true) {
            try {
                String inputBudget = inputView.getBudget();
                BudgetValidator.validateInputBudget(inputBudget);
                return new Budget(Integer.parseInt(inputBudget));
            } catch (IllegalArgumentException e) {
                errorView.printError(e.getMessage());
            }
        }
    }
}
