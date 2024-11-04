package lotto.controller;

import lotto.domain.lotto.Bonus;
import lotto.Lotto;
import lotto.domain.player.Player;
import lotto.domain.player.PlayerLotto;
import lotto.service.LottoService;
import lotto.service.PlayerService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    private final LottoService lottoService;
    private final PlayerService playerService;

    public LottoController(
            InputView inputView,
            OutputView outputView,
            LottoService lottoService,
            PlayerService playerService
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.playerService = playerService;
    }

    public void run() {
        purchaseLotto();
        receiveWinningNumbers();
        receiveBonusNumber();
        startLottoGame();
        getLottoResult();
    }

    private void purchaseLotto() {
        outputView.printPriceInputMessage();
        int purchasePrice = inputView.readPriceInput();
        int lottoCount = playerService.updateLottoCount(purchasePrice);
        playerService.addLottos(lottoCount);
        outputView.printLottoCountOutputMessage(playerService.getPlayer());
        outputView.printLottoNumbers(playerService.getPlayer());
    }

    private void receiveWinningNumbers() {
        outputView.printWinningNumberInputMessage();
        List<Integer> winningNumbers = inputView.readWinningNumberInput();
        lottoService.addWinningNumbers(winningNumbers);
    }

    private void receiveBonusNumber() {
        outputView.printBonusNumberInputMessage();
        int bonusNumber = inputView.readBonusNumberInput(lottoService.getLotto().getNumbers());
        lottoService.updateBonusNumber(bonusNumber);
    }

    private void startLottoGame() {
        List<PlayerLotto> playerLottos = playerService.getPlayer().getLottos();
        for (PlayerLotto playerLotto : playerLottos) {
            playerService.calculateWinningCount(playerLotto);
        }
        playerService.updatePlayerResult(playerService.getPlayer());
    }

    private void getLottoResult() {
        outputView.printResultMessage();
        outputView.printLottoResult(playerService.getPlayer());
    }

}
