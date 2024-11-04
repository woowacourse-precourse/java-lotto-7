package lotto.controller;

import lotto.common.ExceptionConstant;
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
        LottoPrice lottoPrice = promptForValidLottoPrice();

        LottoGame lottoGame = new LottoGame(lottoPrice);
        lottoGame.buyLotto();
        List<String> lottos = lottoGame.getLottos().stream()
                .map(lotto -> LottoNumberFormatter.formatLottoNumbers(lotto.getNumbers()))
                .collect(Collectors.toList());
        outputView.printLottos(lottos, lottos.size());

        List<LottoNumber> winningNumbers = promptForValidWinningNumbers();
        LottoNumber bonusNumber = promptForValidBonusNumber(winningNumbers);

        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);
        lottoGame.checkWinningLotto(winningLotto);

        outputView.printWinningStatistics(lottoGame.getPrizeCounts());
        outputView.printProfit(lottoGame.calculateProfit());
    }

    private LottoPrice promptForValidLottoPrice() {
        try {
            return LottoPrice.valueOf(inputView.inputPrice());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return promptForValidLottoPrice();
        }
    }

    private List<LottoNumber> promptForValidWinningNumbers() {
        try {
            return new Lotto(NumberParser.parseWinningNumbers(inputView.inputWinningNumber())).getNumbers();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return promptForValidWinningNumbers();
        }
    }

    private LottoNumber promptForValidBonusNumber(List<LottoNumber> winningNumbers) {
        try {
            return validateBonusNumber(winningNumbers, LottoNumber.valueOf(inputView.inputBonusNumber()));
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return promptForValidBonusNumber(winningNumbers);
        }
    }

    private LottoNumber validateBonusNumber(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionConstant.ERROR_MESSAGE + ExceptionConstant.BONUS_BALL_DUPLICATION_MESSAGE);
        }
        return bonusNumber;
    }
}
