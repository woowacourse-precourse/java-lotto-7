package lotto.services;

import lotto.views.*;
import lotto.models.PreIssueModel;

public class PreIssueService {
    private final InputView inputView;
    private final OutputView outputView;

    public PreIssueService(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void preIssue() {
        String amountInput = inputView.requestUserInput(InputView.promptForInput.Purchase);
        try {
            PreIssueModel preIssueModel = new PreIssueModel(amountInput);
            outputView.displayPurchaseAmount(preIssueModel.getAmount());
        } catch (IllegalArgumentException e) {
            preIssue();
        }
    }
}
