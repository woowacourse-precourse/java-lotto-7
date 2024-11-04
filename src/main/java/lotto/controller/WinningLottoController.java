package lotto.controller;

import lotto.service.LottoIssueService;
import lotto.view.View;
import lotto.view.VoidView;

public class WinningLottoController implements Controller {

    private static final String WINNING_LOTTO_ISSUE_PROMPT = "\n당첨 번호를 입력해 주세요.";

    private final LottoIssueService lottoIssueService;

    public WinningLottoController(LottoIssueService lottoIssueService) {
        this.lottoIssueService = lottoIssueService;
    }

    @Override
    public View execute() {
        lottoIssueService.issue(WINNING_LOTTO_ISSUE_PROMPT);
        return new VoidView();
    }
}
