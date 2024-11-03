package lotto.service;

import lotto.dto.LottoResult;
import lotto.model.Lotto;
import lotto.model.budget.Budget;
import lotto.model.LottoGame;
import lotto.model.win.WinningNumbers;

public class LottoService {

    public LottoGame buyLotto(Budget budget) {
        LottoGame game = new LottoGame(budget);
        return game;
    }

    public WinningNumbers createWinningNumbers(Lotto lotto, int bonus) {
        WinningNumbers winner = new WinningNumbers(lotto, bonus);
        return winner;
    }

    public LottoResult playLotto(LottoGame game, WinningNumbers winner) {
        LottoResult result = game.play(winner);
        return result;
    }
}
