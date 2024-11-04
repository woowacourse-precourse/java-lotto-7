package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, LottoService lottoService) {
        this.inputView = inputView;
        this.lottoService = lottoService;
    }

    public void handle() {
        int price = inputView.getInput();
        // 로또 발행하기
        List<Lotto> lottoTicket = lottoService.issueLotto(price);
        // 당첨번호 및 보너스번호 입력받기
        List<Integer> winningNumber = inputView.getWinningNumbers();
        int bonusNumber = inputView.getBonusNumber(winningNumber);

        WinningLotto winningLotto = lottoService.issueWinningLotto(winningNumber, bonusNumber);
        // 당첨 통계 및 수익률 출력
        LottoStatistics statistics = LottoStatistics.of(lottoTicket, winningLotto);
    }
}
