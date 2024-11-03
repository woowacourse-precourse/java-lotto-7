package lotto.controller;

import java.util.Optional;
import java.util.function.Supplier;
import lotto.config.ErrorMessage;
import lotto.model.budget.Budget;
import lotto.model.LottoGame;
import lotto.service.LottoService;
import lotto.service.ValidationService;
import lotto.view.BudgetInputView;
import lotto.view.LottoGameOutputView;
import lotto.view.View;

public class BudgetController implements Supplier<LottoGame> {

    private final View budgetView;
    private LottoService lottoService;
    private ValidationService validator;
    public BudgetController() {
        budgetView = new BudgetInputView();
        lottoService = new LottoService();
        validator = new ValidationService();
    }

    @Override
    public LottoGame get() {
        Optional<String> optionalBudget = budgetView.render();
        optionalBudget.orElseThrow(() -> new IllegalArgumentException(ErrorMessage.STOP));

        int money = validator.isNumber(optionalBudget.get());
        Budget budget = new Budget(money);
        LottoGame game = lottoService.buyLotto(budget);
        View view = new LottoGameOutputView(game);
        view.render();

        return game;
    }
}
