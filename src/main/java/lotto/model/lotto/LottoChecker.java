package lotto.model.lotto;

import lotto.model.Winning;
import lotto.model.draw_numbers.DrawNumbers;

import java.util.List;
import java.util.Optional;

public class LottoChecker {

    public double calcRevenueRate(List<Lotto> lottos, DrawNumbers drawNumbers) {
        long lottoCount = lottos.size();
        Long totalPrize = calcTotalPrize(lottos, drawNumbers);
        return ((double) totalPrize * 100) / (lottoCount * Lotto.PRICE);
    }

    private Long calcTotalPrize(List<Lotto> lottos, DrawNumbers drawNumbers) {
        Optional<Long> optionalTotalPrize = lottos.stream()
                .map(lotto -> {
                    Winning winning = lotto.checkWinner(drawNumbers);
                    winning.increaseCount();
                    return winning.getPrizeMoney();
                })
                .reduce(Long::sum);
        return optionalTotalPrize.get();
    }
}
