package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.LottoGameResult;
import lotto.model.LottoPurchase;
import lotto.model.WinningLotto;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.ResultFormatter;

public final class LottoGameController {

    private final ResultFormatter resultFormatter;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameController(ResultFormatter resultFormatter, InputView inputView, OutputView outputView) {
        this.resultFormatter = resultFormatter;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        while (true) {
            try {
                play();
                break;
            } catch (IllegalArgumentException e) {
                outputView.errorMessagePrint(e.getMessage());
            }
        }
    }

    private void play() {
        LottoPurchase lottoPurchase = buyLotto();
        LottoGame lottoGame = playLottoGame(lottoPurchase);
        showLottoGameResult(lottoGame);
    }

    private LottoPurchase buyLotto() {
        LottoPurchase lottoPurchase = new LottoPurchase(readMoney());

        outputView.print(resultFormatter.formatLottoPurchaseResult(lottoPurchase.getLottoPurchaseResult()));

        return lottoPurchase;
    }

    private LottoGame playLottoGame(LottoPurchase lottoPurchase) {
        List<Integer> winningLottoNumbers = readWinningLottoNumbers();
        Lotto winningLotto = new Lotto(winningLottoNumbers);
        int bonusNumber = readBonusNumber();

        return new LottoGame(lottoPurchase.getLottoTickets(), new WinningLotto(winningLotto, bonusNumber),
                lottoPurchase.getMoney());
    }

    private void showLottoGameResult(LottoGame lottoGame) {
        LottoGameResult lottoGameResult = lottoGame.calculateLottoResults();

        outputView.print(resultFormatter.formatLottoGameResult(lottoGameResult));
    }

    private int readMoney() {
        String moneyInput = inputView.getMoneyInput();
        outputView.printNewLine();

        Validator.validateMoneyInput(moneyInput);

        return Integer.parseInt(moneyInput);
    }

    private List<Integer> readWinningLottoNumbers() {
        String numbersInput = inputView.getNumbersInput();
        outputView.printNewLine();

        Validator.validateNumbersInput(numbersInput);

        return Arrays.stream(numbersInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int readBonusNumber() {
        String bonusNumberInput = inputView.getBonusInput();

        Validator.validateBonusNumberInput(bonusNumberInput);

        return Integer.parseInt(bonusNumberInput);
    }
}
