package lotto.manager;

import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.Result;
import lotto.util.io.Reader;
import lotto.util.io.Writer;
import lotto.util.function.LottoNumberSupplier;

import java.util.List;

/*
* 게임 흐름을 알고 게임을 진행하는 클래스
* */
public class GameController {
    private final LottoNumberSupplier lottoNumberSupplier;
    private final LottoSeller lottoSeller;
    private final GameResultManager gameResultManager;

    public GameController(LottoNumberSupplier lottoNumberSupplier) {
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

    private void getWinningLotto() {
        Lotto lotto = getLottoWithWinningNumbers();

        while (true) {
            try {
                int bonusNumber = getBonusNumer();
                gameResultManager.changeWinningLotto(lotto, bonusNumber);
                break;
            }
            catch (IllegalArgumentException e) {
                Writer.writeMessage(e.getMessage());
            }
        }
    }

    private Lotto getLottoWithWinningNumbers() {
        Lotto lotto;

        while (true) {
            try {
                List<Integer> winningNumbers = Reader.readWinningNumbers();
                lotto = new Lotto(winningNumbers);
                break;
            }
            catch (IllegalArgumentException e) {
                Writer.writeMessage(e.getMessage());
            }
        }

        return lotto;
    }

    private int getBonusNumer() {
        int bonusNumber;

        while (true) {
            try {
                bonusNumber = Reader.readBonusNumber();
                break;
            }
            catch (IllegalArgumentException e) {
                Writer.writeMessage(e.getMessage());
            }
        }

        return bonusNumber;
    }
}
