package lotto.week3.controller;

import lotto.week3.dto.PurchaseRequestDto;
import lotto.week3.dto.WinningNumberRequestDto;
import lotto.week3.global.error.handler.InputHandler;
import lotto.week3.domain.LottoMatching;
import lotto.week3.model.LottoStatistics;
import lotto.week3.service.LottoService;
import lotto.week3.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        try {
            // 구입 금액 입력
            PurchaseRequestDto purchaseAmount = InputHandler.purchaseInputHandler();

            // 로또 발행
            LottoMatching matching = lottoService.generatorLottos(purchaseAmount);

            OutputView.lottoOutput(matching.getLottos());

            WinningNumberRequestDto winningNumberRequestDto = InputHandler.winningNumberRequestDto();

            // 뽀너스 입력, 당첨 번호 입력
            lottoService.calculateWinningStatistics(matching, winningNumberRequestDto);

            /*
            로또 번호 매칭 - > 당첨번호랑 자동 발급된 번호 매칭 -> 확률 구현
             */
            LottoStatistics statistics = matching.getLottoStatistics();
            double calculateYied = lottoService.calculateYied(statistics, purchaseAmount.getMoney());
            OutputView.lottoStatisticsOutput(statistics.getStatisticsRequestDto(), statistics.calculateTotalPrize(),
                    calculateYied);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

    }
}
