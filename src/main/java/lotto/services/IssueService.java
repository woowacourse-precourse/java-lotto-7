package lotto.services;

import lotto.views.OutputView;
import lotto.models.IssueModel;

public class IssueService {
    private final OutputView outputView;

    public IssueService(OutputView outputView) {
        this.outputView = outputView;
    }

    public void issue(int amount) {
        IssueModel issueModel = new IssueModel(amount);
        outputView.displayIssuedNumbers(issueModel.getAllIssuedLottos());
    }
}
