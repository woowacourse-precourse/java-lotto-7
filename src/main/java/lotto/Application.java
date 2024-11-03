package lotto;

import lotto.controller.LottoController;
import lotto.domain.lotto.Bonus;
import lotto.domain.player.Player;
import lotto.service.LottoService;
import lotto.service.PlayerService;
import lotto.util.IntegerParser;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Lotto lotto = new Lotto();
        Bonus bonus = new Bonus();
        Player player = new Player();

        LottoService lottoService = new LottoService(lotto, bonus);
        PlayerService playerService = new PlayerService(player, lotto, bonus);

        LottoController controller = new LottoController(inputView, outputView, lottoService, playerService);
        controller.run();
    }
}
