package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.service.LottoService;
import lotto.util.NumericConverter;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;
    private static final String DELIMITER = ",";
    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<Lotto> lottos = buyLotto();
        outputView.printGeneratedLottos(lottos);
        Result result = calculateWinning(lottos);
        outputView.printResult(result.getRankResults());
        outputView.printProfitRate(result.getProfitRate());
    }

    private List<Lotto> buyLotto() {
        while (true) {
            try {
                String purchaseAmount = inputView.getPurchaseAmount();
                return lottoService.issueLotto(NumericConverter.convert(purchaseAmount));
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Result calculateWinning(List<Lotto> issuedLottos) {
        while(true) {
            try {
                List<Integer> winningNumber = Arrays.stream(inputView
                                .getWinningNumber()
                                .split(DELIMITER))
                        .map(NumericConverter::convert).toList();
                Integer bonusNumber = NumericConverter.convert(inputView.getBonusNumber());
                return lottoService.runLottoGame(winningNumber, bonusNumber, issuedLottos);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
