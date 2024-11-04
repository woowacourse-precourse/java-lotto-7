package lotto.controller;

import java.util.List;
import lotto.model.Rank;
import lotto.service.LottoService;
import lotto.view.Inputview;
import lotto.view.Outputview;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        try {
            // 1. 구입 금액 입력
            int money = Inputview.inputMoney();

            // 2. 로또 티켓 발행
            lottoService.issueLottoTickets(money / 1000);
            Outputview.printLottoTickets(lottoService.getLottoTickets());

            // 3. 당첨 번호와 보너스 번호 입력
            String winningNumbers = Inputview.inputWinningNumbers();
            int bonusNumber = Inputview.inputBonusNumber();
            lottoService.setWinningNumbers(winningNumbers, bonusNumber);

            // 4. 당첨 결과 계산 및 출력
            List<Rank> results = lottoService.calculateResults();
            Outputview.printResults(results);

            // 5. 수익률 계산 및 출력
            double yield = lottoService.calculateYield(money);
            Outputview.printYield(yield);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            run(); // 잘못된 입력 발생 시 재시도
        }
    }
}
