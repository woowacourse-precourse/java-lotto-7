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
        lottoIssueService.issue("\n당첨 번호를 입력해 주세요.");
        return new VoidView();
    }
}
