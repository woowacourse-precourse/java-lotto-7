package lotto.controller;

import lotto.domain.lotto.Bonus;
import lotto.domain.lotto.Lotto;
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

    private final Lotto lotto;
    private final Player player;
    private final Bonus bonus;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lotto = new Lotto();
        this.player = new Player();
        this.bonus = new Bonus();
        this.lottoService = new LottoService(lotto, bonus);
        this.playerService = new PlayerService(player, lotto, bonus);
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
        outputView.printLottoCountOutputMessage(player);
        outputView.printLottoNumbers(player);
    }

    private void receiveWinningNumbers() {
        outputView.printWinningNumberInputMessage();
        List<Integer> winningNumbers = inputView.readWinningNumberInput();
        lottoService.addWinningNumbers(winningNumbers);
    }

    private void receiveBonusNumber() {
        outputView.printBonusNumberInputMessage();
        int bonusNumber = inputView.readBonusNumberInput(lotto.getNumbers());
        lottoService.updateBonusNumber(bonusNumber);
    }

    private void startLottoGame() {
        List<PlayerLotto> playerLottos = player.getLottos();
        for (PlayerLotto playerLotto : playerLottos) {
            playerService.calculateWinningCount(playerLotto);
        }
        playerService.updatePlayerResult(player);
    }

    private void getLottoResult() {
        outputView.printResultMessage();
        outputView.printLottoResult(player);
    }
}
