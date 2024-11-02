package lotto.service;

import lotto.global.util.RandomGenerator;
import lotto.model.Game;
import lotto.model.Lotto;
import lotto.model.WinningCount;
import lotto.model.WinningNumbers;
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
        countWinningLottos(game);
        WinningCount winningCount = game.getWinningCount();
        outputView.printWinningResult(winningCount);
        double rateOfReturn = getRateOfReturn(game.getWinningAmount(), winningCount);
        outputView.printRateOfReturn(rateOfReturn);
    }

    private void countWinningLottos(Game game) {
        WinningCount winningCount = game.getWinningCount();
        game.getLottos().getLottos().forEach(
                lotto -> {
                    Integer index = findWinnigLotto(lotto, game.getWinningNumbers());
                    winningCount.increaseWinningCount(index);
                });
    }

    private Integer findWinnigLotto(Lotto lotto, WinningNumbers winningNumbers) {
        List<Integer> numbers = lotto.getNumbers();
        int count = (int) numbers.stream().filter(winningNumbers.getWinningNumber()::contains)
                .count();
        boolean hasBonus = numbers.contains(winningNumbers.getBonusNumber());

        if (count == 6) {
            return 5;
        }
        if (count == 5 && hasBonus) {
            return 4;
        }
        if (count >= 3) {
            return count - 2;
        }
        return 0;
    }

    public double getRateOfReturn(List<Integer> winningAmount, WinningCount count) {
        List<Integer> winningCounts = count.getWinningCount();
        float size = winningCounts.stream().mapToInt(i -> i).sum();
        float profit = calculateProfit(winningAmount, winningCounts);
        return calculateRateOfReturn(size, profit);
    }

    public float calculateProfit(List<Integer> winningAmount, List<Integer> winningCounts) {
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            sum += winningAmount.get(i) * winningCounts.get(i);
        }
        return sum;
    }

    public double calculateRateOfReturn(float size, float profit) {
        return Math.round(profit / size * 1000) / 10.0;
    }
}
