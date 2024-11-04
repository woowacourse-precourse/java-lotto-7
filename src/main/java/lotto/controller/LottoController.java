package lotto.controller;

import lotto.model.*;
import lotto.util.LottoNumberFormatter;
import lotto.util.NumberParser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        LottoPrice lottoPrice = LottoPrice.valueOf(inputView.inputPrice());

        LottoGame lottoGame = new LottoGame(lottoPrice);
        lottoGame.buyLotto();
        List<String> lottos = lottoGame.getLottos().stream()
                .map(lotto -> LottoNumberFormatter.formatLottoNumbers(lotto.getNumbers()))
                .collect(Collectors.toList());
        outputView.printLottos(lottos, lottos.size());

        List<LottoNumber> winningNumbers = NumberParser.parseWinningNumbers(inputView.inputWinningNumber());
        LottoNumber bonusNumber = LottoNumber.valueOf(inputView.inputBonusNumber());

        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);
        lottoGame.checkWinningLotto(winningLotto);

        outputView.printWinningStatistics(lottoGame.getPrizeCounts());
        outputView.printProfit(lottoGame.calculateProfit());
    }
}
