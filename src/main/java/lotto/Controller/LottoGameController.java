package lotto.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Domain.Lotto;
import lotto.Domain.LottoGame;
import lotto.Domain.MoneyValidator;
import lotto.Domain.WinningLotto;
import lotto.Enum.LottoPrizeRank;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        LottoGame game = createGame(getPurchaseAmount());
        printPurchasedLottos(game.getLottos());
        WinningLotto winningLotto = createWinningLotto();
        game.checkResult(winningLotto);
        printGameResults(game);
    }

    private int getPurchaseAmount() {
        String input = inputView.readPurchaseAmount();
        MoneyValidator.validate(input);
        return Integer.parseInt(input);
    }

    private LottoGame createGame(int amount) {
        return new LottoGame(amount);
    }

    private WinningLotto createWinningLotto() {
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private List<Integer> getWinningNumbers() {
        String input = inputView.readWinningNumbers();
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int getBonusNumber() {
        String input = inputView.readBonusNumber();
        return Integer.parseInt(input);
    }

    private void printPurchasedLottos(List<Lotto> lottos) {
        outputView.printPurchaseResult(lottos.size());
        lottos.forEach(this::printLotto);
    }

    private void printLotto(Lotto lotto) {
        outputView.printLottoNumbers(lotto.getNumbers());
    }

    private void printGameResults(LottoGame game) {
        outputView.printStatisticsTitle();
        printPrizeResults(game);
        printProfitRate(game);
    }

    private void printPrizeResults(LottoGame game) {
        Arrays.stream(LottoPrizeRank.values())
                .filter(rank -> !rank.equals(LottoPrizeRank.MISS))
                .forEach(rank -> printPrizeResult(rank, game));
    }

    private void printPrizeResult(LottoPrizeRank rank, LottoGame game) {
        outputView.printMatchResult(rank.resultMessage, game.getWinningCount(rank));
    }

    private void printProfitRate(LottoGame game) {
        outputView.printProfitRate(game.calculateProfitRate());
    }
}