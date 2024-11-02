package lotto.controller;

import java.util.List;
import lotto.dto.LottoInputDTO;
import lotto.model.Lotto;
import lotto.model.LottoResults;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        LottoInputDTO inputData = inputView.inputLottoData();

        List<Lotto> purchasedLottos = lottoService.generateLottos(inputData.getPurchaseAmount());
        outputView.displayLottos(purchasedLottos);

        LottoResults results = lottoService.calculateResult(
                purchasedLottos,
                new Lotto(inputData.getWinningNumbers()), // 당첨 번호
                Integer.parseInt(inputData.getBonusNumber()) // 보너스 번호
        );

    }


}
