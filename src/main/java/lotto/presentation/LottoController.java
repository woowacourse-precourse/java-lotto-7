package lotto.presentation;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.LottoGame;
import lotto.domain.LottoGenerateStrategy;

public class LottoController {
    private static final int MONEY_THRESHOLD = 1000;
    private final LottoGenerateStrategy lottoGenerateStrategy;

    public LottoController(LottoGenerateStrategy lottoGenerateStrategy) {
        this.lottoGenerateStrategy = lottoGenerateStrategy;
    }

    public void run() {
        int money = getMoneyInput();
        LottoGame lottoGame = new LottoGame(money, lottoGenerateStrategy);
        OutputView.printPurchasedLottos(lottoGame.getPurchasedLotto());

        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber(winningNumbers);

        LottoResultFormatter lottoResultFormatter = generateLottoResult(lottoGame, winningNumbers, bonusNumber);
        displayResult(lottoResultFormatter, lottoGame, winningNumbers, bonusNumber);
    }

    private int getMoneyInput() {
        int money = convertStringToMoney(InputView.getMoney());
        OutputView.printPurchaseAmount(money / MONEY_THRESHOLD);
        return money;
    }

    private int convertStringToMoney(String money) {
        return Integer.parseInt(money);
    }

    private List<Integer> inputWinningNumbers() {
        return convertStringToNumberList(InputView.getNumbers());
    }

    private int inputBonusNumber(List<Integer> winningNumbers) {
        return convertStringToNumber(InputView.getBonusNumber(winningNumbers));
    }

    private LottoResultFormatter generateLottoResult(LottoGame lottoGame, List<Integer> winningNumbers, int bonusNumber) {
        return new LottoResultFormatter(lottoGame.getPrizes(winningNumbers, bonusNumber));
    }

    private void displayResult(LottoResultFormatter lottoResultFormatter, LottoGame lottoGame, List<Integer> winningNumbers, int bonusNumber) {
        OutputView.printResult(lottoResultFormatter.generateSummary());
        float earningRate = lottoGame.getEarningRate(winningNumbers, bonusNumber);
        OutputView.printEarningRate(earningRate);
    }

    private int convertStringToNumber(String number) {
        return Integer.parseInt(number);
    }

    private List<Integer> convertStringToNumberList(String numbers) {
        return Stream.of(numbers.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
