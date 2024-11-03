package lotto.model.lotto;

import lotto.model.Winning;
import lotto.model.draw_numbers.DrawNumbers;

import java.util.List;
import java.util.Optional;

public class LottoMachine {

    private final DrawNumbers drawNumbers;

    public LottoMachine(DrawNumbers drawNumbers) {
        this.drawNumbers = drawNumbers;
    }

    public double examineLotto(List<Lotto> lottos, long lottoCount) {
        Long totalPrize = calcTotalPrize(lottos);
        return ((double) totalPrize * 100) / (lottoCount * Lotto.PRICE);
    }

    private Long calcTotalPrize(List<Lotto> lottos) {
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
