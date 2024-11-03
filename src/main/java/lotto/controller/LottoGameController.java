package lotto.controller;

import java.util.List;
import lotto.handler.LottoInputHandler;
import lotto.handler.ResultHandler;
import lotto.service.LottoService;
import lotto.view.ErrorView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final LottoService lottoService;
    private final LottoInputHandler inputHandler;
    private final ResultHandler resultHandler;

    public LottoGameController(LottoService lottoService, InputView inputView, ErrorView errorView,
                               OutputView outputView) {
        this.lottoService = lottoService;
        this.inputHandler = new LottoInputHandler(inputView, errorView);
        this.resultHandler = new ResultHandler(lottoService, outputView);
    }

    public void run() {
        try {
            // 1. 사용자로부터 구매 금액 입력 및 로또 티켓 생성
            int purchaseAmount = inputHandler.getPurchaseAmount();
            lottoService.generateLottoTickets(purchaseAmount);

            // 로또 구매 내역 출력
            resultHandler.displayLottoPurchase();

            // 2. 사용자로부터 당첨 번호와 보너스 번호 입력 받기
            List<Integer> winningNumbers = inputHandler.getWinningNumbers();
            int bonusNumber = inputHandler.getBonusNumber(winningNumbers);
            lottoService.setWinningNumbers(winningNumbers, bonusNumber);

            // 3. 결과 계산 및 출력
            resultHandler.calculateAndDisplayResults();
            resultHandler.displayProfitRate(purchaseAmount);
        } finally {
            inputHandler.close();
        }
    }

}
