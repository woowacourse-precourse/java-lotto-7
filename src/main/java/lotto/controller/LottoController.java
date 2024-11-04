package lotto.controller;

import java.util.List;
import lotto.common.Constants;
import lotto.model.LottoFactory;
import lotto.model.Lottos;
import lotto.service.InputParser;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputParser inputParser;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputParser inputParser, OutputView outputView, LottoService lottoService) {
        this.inputParser = inputParser;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void start() {
        inputParser.lottoPurchaseDTO();
        outputView.showStatistics();
    }

}
