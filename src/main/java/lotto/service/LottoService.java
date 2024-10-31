package lotto.service;

import lotto.global.util.RandomGenerator;
import lotto.model.Game;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningCountDTO;
import lotto.view.OutputView;

import java.util.List;

public class LottoService {
    private static final RandomGenerator randomGenerator = RandomGenerator.getInstance();
    private static final OutputView outputView = OutputView.getInstance();
    public Lotto createLotto() {
        List<Integer> lottoNumbers = randomGenerator.generate();
        return new Lotto(lottoNumbers);
    }

    public void run(Game game) {
        WinningCountDTO winningCountDTO = countWinningLottos(game);
        outputView.printWinningResult(winningCountDTO);
    }

    private WinningCountDTO countWinningLottos(Game game) {
        WinningCountDTO winningCountDTO = new WinningCountDTO();
        game.getLottos().getLottos().forEach(
                lotto -> {
                    Integer index = checkWinnigLotto(lotto, game);
                    if (index != null) {
                        winningCountDTO.increaseWinningCount(index);
                    }
                });
        return winningCountDTO;
    }

    private Integer checkWinnigLotto(Lotto lotto, Game game) {
        List<Integer> numbers = lotto.getNumbers();
        int count = (int) numbers.stream().filter(game.getWinningNumbers()::contains)
                .count();
        boolean hasBonus = numbers.contains(game.getBonusNumber());
        if (count == 6) {
            return 4;
        }
        if (count == 5 && hasBonus) {
            return 3;
        }
        if (count < 3) {
            return null;
        }
        return count - 3;
    }
}
