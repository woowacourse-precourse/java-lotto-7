package lotto.service;

import lotto.global.util.RandomGenerator;
import lotto.model.Game;
import lotto.model.Lotto;
import lotto.model.WinningCountDTO;
import lotto.view.OutputView;

import java.util.List;

public class LottoService {
    private static final RandomGenerator randomGenerator = RandomGenerator.getInstance();
    private static final OutputView outputView = OutputView.getInstance();

    public Lotto createLotto() {
        List<Integer> lottoNumbers = randomGenerator.generate();
        try {
            return new Lotto(lottoNumbers);
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            return createLotto();
        }
    }

    public void run(Game game) {
        WinningCountDTO winningCountDTO = countWinningLottos(game);
        outputView.printWinningResult(winningCountDTO);
        calculateRateOfReturn(winningCountDTO);
    }

    private WinningCountDTO countWinningLottos(Game game) {
        WinningCountDTO winningCountDTO = new WinningCountDTO();
        game.getLottos().getLottos().forEach(
                lotto -> {
                    Integer index = checkWinnigLotto(lotto, game);
                    winningCountDTO.increaseWinningCount(index);
                });
        return winningCountDTO;
    }

    private Integer checkWinnigLotto(Lotto lotto, Game game) {
        List<Integer> numbers = lotto.getNumbers();
        int count = (int) numbers.stream().filter(game.getWinningNumbers()::contains)
                .count();
        boolean hasBonus = numbers.contains(game.getBonusNumber());
        if (count == 6) {
            return 5;
        }
        if (count == 5 && hasBonus) {
            return 4;
        }
        if (count < 3) {
            return 0;
        }
        return count - 2;
    }

    public void calculateRateOfReturn(WinningCountDTO winningCountDTO) {
        List<Integer> winningCounts = winningCountDTO.getWinningCount();
        float size = winningCounts.stream().mapToInt(i -> i).sum();
        float profit = winningCounts.get(1) * 5 + winningCounts.get(2) * 50 + winningCounts.get(3) * 1500 + winningCounts.get(4) * 30000 + winningCounts.get(5) * 2000000;
        double rateOfReturn = Math.round(profit / size * 100);
        outputView.printRateOfReturn(rateOfReturn);
    }
}
