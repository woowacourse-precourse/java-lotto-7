package lotto.controller;

import java.util.List;
import lotto.dto.LottoRequestDTO;
import lotto.dto.LottoResponseDTO;
import lotto.model.Lotto;
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
        LottoRequestDTO requestDTO = inputView.inputLottoData();

        List<Lotto> purchasedLottos = lottoService.generateLottos(requestDTO.getPurchaseAmount());
        outputView.displayLottos(purchasedLottos);

        // 결과 계산 및 DTO 반환
        LottoResponseDTO lottoResponseDTO = lottoService.calculateResult(
                purchasedLottos,
                new Lotto(requestDTO.getWinningNumbers()),  // 당첨 번호
                requestDTO.getBonusNumber()                 // 보너스 번호
        );
    }
}
