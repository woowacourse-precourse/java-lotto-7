package lotto;

import lotto.model.Budget;
import lotto.util.BudgetValidator;
import lotto.view.ErrorView;
import lotto.view.InputView;

public class LottoApplication {
    final InputView inputView;
    final ErrorView errorView;

    public LottoApplication(InputView inputView, ErrorView errorView) {
        this.inputView = inputView;
        this.errorView = errorView;
    }

    public void run() {
        Budget budget = getValidatedBudget();
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
