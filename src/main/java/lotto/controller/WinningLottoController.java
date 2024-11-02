package lotto.controller;

import lotto.service.LottoIssueService;
import lotto.view.View;
import lotto.view.VoidView;

public class WinningLottoController implements Controller {

    private final LottoIssueService lottoIssueService;

    public WinningLottoController(LottoIssueService lottoIssueService) {
        this.lottoIssueService = lottoIssueService;
    }

    @Override
    public View execute() {
        lottoIssueService.issue(1);
        return new VoidView();
    }
}
