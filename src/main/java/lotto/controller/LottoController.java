package lotto.controller;

import lotto.domain.InputMoney;
import lotto.domain.LottoResult;
import lotto.service.LottoService;
import lotto.domain.Lottos;
import lotto.domain.BonusNumber;
import lotto.domain.WinningNumbers;
import lotto.utils.InputHandler;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputHandler inputHandler;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputHandler inputHandler, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputHandler = inputHandler;
        this.outputView = outputView;
    }

    public void start() {
        // Step 1: 구입 금액 입력
        InputMoney inputMoney = inputHandler.getInputMoney();

        // Step 2 : 주어진 금액으로 로또 구매
        Lottos lottos = lottoService.buyLottos(inputMoney);

        // Step 3: 구매한 로또 출력
        outputView.displayBuyLottos(lottos);

        // Step 4: 당첨 번호 및 보너스 번호 입력
        WinningNumbers winningNumbers = inputHandler.getWinningNumbers();
        BonusNumber bonusNumber = inputHandler.getBonusNumber();

        // Step 5: 로또 결과 계산
        LottoResult lottoResult = lottos.getLottoResult(winningNumbers, bonusNumber,inputMoney);

        // Step 6: 결과 출력
        outputView.displayWinningResult(lottoResult);
    }
}