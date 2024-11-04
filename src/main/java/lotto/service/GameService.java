package lotto.service;

import java.util.List;
import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.util.LottoGenerator;

public class GameService {
    private final LottoGenerator lottoGenerator;

    public GameService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Game createGame(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        return new Game(lottos, winningNumbers, bonusNumber);
    }

    public List<Lotto> generateLottos(int amount) {
        return lottoGenerator.generateLottos(amount);
    }

    public int[] getResults(Game game, Lotto winningLotto) {
        return game.compareNumbers(winningLotto);
    }

    public double calculateRateOfReturn(Game game, int purchaseAmount, int[] results) {
        return game.calculateRateOfReturn(purchaseAmount, results);
    }


}
