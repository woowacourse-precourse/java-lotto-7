package controller;

import validation.BudgetValidator;
import view.InputView;


public class StartLotto {
    public static void run() {
        int budget = inputBudget();
    }

    private static int inputBudget() {
        String budget = InputView.getInputBudget();
        try {
            BudgetValidator.validate(budget);
        } catch (IllegalArgumentException e) {
            return inputBudget();
        }
        return Integer.parseInt(budget);
    }
}