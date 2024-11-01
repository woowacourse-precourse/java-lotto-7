package lotto.services;

import lotto.views.InputView;
import lotto.views.OutputView;
import lotto.models.PreIssueModel;

public class PreIssueService {
    private final InputView inputView;
    private final OutputView outputView;
    private final PreIssueModel preIssueModel;
    public PreIssueService(InputView inputView, OutputView outputView, PreIssueModel preIssueModel) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.preIssueModel = preIssueModel;
    }

    public void PreIssue() {
        String purchaseAmount = inputView.requestUserInput(InputView.promptForInput.Purchase);
        int amount = 0;
        try {
            amount = preIssueModel.calculateAmount(purchaseAmount);
            outputView.displayPurchaseAmount(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 양의 정수여야 합니다.");
        } catch (IllegalArgumentException e) {
            PreIssue();
        }
    }
}
