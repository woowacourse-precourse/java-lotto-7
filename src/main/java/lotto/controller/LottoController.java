package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoService;
import lotto.model.StringParser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final StringParser stringParser;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, StringParser stringParser, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.stringParser = stringParser;
        this.lottoService = lottoService;
    }

    public void Game() {
        List<Lotto> lottos = purchaseLottos();
        checkNumbers(lottos);
    }


    private List<Lotto> purchaseLottos() {
        while (true) {
            try {
                String rawAmount = inputView.readAmount();
                Integer lottoCount = stringParser.findLottoCount(rawAmount);
                outputView.printLottoCount(lottoCount);
                List<Lotto> lottos = lottoService.pickLottoNumbers(lottoCount);
                outputView.printLottoNumbers(lottos);
                return lottos;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void checkNumbers(List<Lotto> lottos) {
        List<String> rawNumbers = inputView.readNumbers();
        List<Integer> myNumbers = stringParser.findMyNumbers(rawNumbers.get(0));
        Integer bonusNumber = stringParser.findBonusNumber(myNumbers, rawNumbers.get(1));
        Map<Integer, Integer> prizeCount = lottoService.checkWinningNumber(lottos, myNumbers, bonusNumber);
        double rateOfReturn = lottoService.calculateRateOfReturn(lottos.size(), prizeCount);

        outputView.printResult(prizeCount, rateOfReturn);
    }


}
