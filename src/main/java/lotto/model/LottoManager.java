package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LottoManager {

    private final Lotto winningNumbers;
    private final int bonusNumber;

    public LottoManager(Lotto winningLotto, int bonusNumber) {
        this.winningNumbers = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Map<LottoWinnerPrize, Integer> getWinningPrizes(List<Lotto> purchasedLottos) {
        Map<LottoWinnerPrize, Integer> prizeCountMap = Arrays.stream(LottoWinnerPrize.values())
                .collect(Collectors.toMap(prize -> prize, prize -> 0));

        purchasedLottos.stream()
                .map(lotto -> determinePrize(lotto.getNumbers()))
                .flatMap(Optional::stream)
                .forEach(winnerPrize -> prizeCountMap.put(winnerPrize, prizeCountMap.get(winnerPrize) + 1));

        return prizeCountMap;
    }

    private Optional<LottoWinnerPrize> determinePrize(List<Integer> numbers) {
        int prizeCount = (int) numbers.stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
        if (prizeCount == LottoWinnerPrize.SECOND_PRIZE.getNumberOfCount()) {
            if (includesBonusBall(numbers)) {
                return Optional.of(LottoWinnerPrize.SECOND_PRIZE);
            }
            return Optional.of(LottoWinnerPrize.THIRD_PRIZE);
        }
        return Arrays.stream(LottoWinnerPrize.values())
                .filter(prize -> prize.getNumberOfCount() == prizeCount)
                .findFirst();
    }

    private boolean includesBonusBall(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }

}
