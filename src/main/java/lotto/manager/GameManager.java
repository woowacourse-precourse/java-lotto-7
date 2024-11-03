package lotto.manager;

import lotto.domain.Player;
import lotto.domain.Result;
import lotto.io.Reader;
import lotto.io.Writer;
import lotto.util.LottoNumberSupplier;

import java.util.List;

/*
* 게임 흐름을 알고 게임을 진행하는 클래스
* */
public class GameManager {
    private final LottoNumberSupplier lottoNumberSupplier;
    private final LottoSeller lottoSeller;
    private final GameResultManager gameResultManager;

    public GameManager(LottoNumberSupplier lottoNumberSupplier) {
        this.lottoNumberSupplier = lottoNumberSupplier;
        this.lottoSeller = new LottoSeller(lottoNumberSupplier);
        this.gameResultManager = new GameResultManager();
    }

    public void run() {
        Player player = sellLottoToPlayer();
        Writer.writeIssuedLottos(player.getLottos());

        getWinningLotto();

        Result result = gameResultManager.getResult(player);

        Writer.writeResult(result);
    }

    private Player sellLottoToPlayer() {
        Player player;

        while (true) {
            try {
                int money = Reader.readMoney();
                player = lottoSeller.sell(money);
                break;
            }
            catch (IllegalArgumentException e) {
                Writer.writeMessage(e.getMessage());
            }
        }

        return player;
    }

    public void getWinningLotto() {
        while (true) {
            try {
                List<Integer> winningNumbers = Reader.readWinningNumbers();
                int bonusNumber = Reader.readBonusNumber();
                gameResultManager.changeWinningLotto(winningNumbers, bonusNumber);
                break;
            }
            catch (IllegalArgumentException e) {
                Writer.writeMessage(e.getMessage());
            }
        }
    }
}
