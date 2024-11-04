package lotto.controller;

import java.util.List;
import lotto.common.Constants;
import lotto.dto.LottoPurchaseDTO;
import lotto.model.LottoFactory;
import lotto.model.Lottos;
import lotto.service.InputParser;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputParser inputParser;
    private final OutputView outputView;
    private final LottoFactory lottoFactory;
    private final LottoService lottoService;

    public LottoController(InputParser inputParser, OutputView outputView, LottoFactory lottoFactory, LottoService lottoService) {
        this.inputParser = inputParser;
        this.outputView = outputView;
        this.lottoFactory = lottoFactory;
        this.lottoService = lottoService;
    }

    public void start() {
        LottoPurchaseDTO lottoPurchaseDTO = inputParser.lottoPurchaseDTO();
        lottoFactory.createLottos(lottoPurchaseDTO);
        outputView.showLottoNumbers(lottoFactory.checkLottos(), lottoPurchaseDTO.getLottoCount());
        lottoFactory.createWinningLotto(lottoPurchaseDTO);
        outputView.showStatistics();
    }

}
