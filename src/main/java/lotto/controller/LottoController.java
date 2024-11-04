package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Player;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.utils.InputParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;
    private final InputHandler inputHandler;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView,
                           InputHandler inputHandler) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputHandler = inputHandler;
    }

    public void run() {
        Player player = createPlayer();

        outputView.displayLottoTickets(player.getLottoTickets());

        WinningLotto winningLotto = createWinningLotto();

        displayResults(player, winningLotto);
    }

    private Player createPlayer() {
        return inputHandler.retryOnError(() -> {
            String purchaseAmount = inputView.requestLottoPurchaseAmount();
            Player player = new Player(purchaseAmount);
            lottoService.buyLotto(player, player.getMoney());
            return player;
        });
    }

    private WinningLotto createWinningLotto() {
        Lotto winningLottoNumber = inputHandler.retryOnError(this::getWinningLottoNumber);
        return inputHandler.retryOnError(() -> getWinningLottoBonus(winningLottoNumber));
    }

    private Lotto getWinningLottoNumber() {
        String input = inputView.requestWinningNumbers();
        List<String> numbersAsString = InputParser.parseCommaSeparatedStrings(input);
        List<Integer> numbers = InputParser.convertStringsToIntegers(numbersAsString);
        return new Lotto(numbers);
    }

    private WinningLotto getWinningLottoBonus(Lotto winningLotto) {
        String input = inputView.requestBonusNumber();
        int bonusNumber = InputParser.stringToInteger(input);
        return new WinningLotto(winningLotto, bonusNumber);
    }

    private void displayResults(Player player, WinningLotto winningLotto) {
        Map<LottoRank, Integer> lottoRankCounts = lottoService.getLottoRankCounts(player, winningLotto);
        outputView.displayLottoResult(lottoRankCounts);

        int totalPrize = lottoService.getTotalPrize(player, winningLotto);
        double profitRate = player.calculateProfitRate(totalPrize);
        outputView.displayProfitRate(profitRate);
    }

}
