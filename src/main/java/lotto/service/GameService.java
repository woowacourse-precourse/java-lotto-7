package lotto.service;

import static lotto.constant.Constants.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.domain.Winning;

public class GameService {

    public Game createGame(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        return new Game(lottos, bonusNumber);
    }

    public List<Lotto> generateLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        int count = amount / LOTTO_PRICE;
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public Lotto generateWinningLotto(List<Integer> winningNumbers) {
        Lotto winningLotto = new Lotto(winningNumbers);
        return winningLotto;
    }

    public Map<Winning, Integer> getResults(Game game, Lotto winningLotto) {
        return game.compareNumbers(winningLotto);
    }

    public double calculateRateOfReturn(Game game, int purchaseAmount, Map<Winning, Integer> results) {
        return game.calculateRateOfReturn(purchaseAmount, results);
    }


}
