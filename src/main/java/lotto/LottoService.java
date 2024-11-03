package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {
    private final LottoGenerator lottoGenerator;
    public final RevenueCalculator revenueCalculator;

    public LottoService(LottoGenerator lottoGenerator, RevenueCalculator revenueCalculator) {
        this.lottoGenerator = lottoGenerator;
        this.revenueCalculator = revenueCalculator;
    }

    public Lottos createLottos(Integer count) {
        return new Lottos(
                IntStream.range(0, count)
                        .mapToObj(i -> lottoGenerator.createLotto())
                        .collect(Collectors.toList()));
    }

    public List<Rank> calculateWinnings(Lottos lottos, WinningNumbers winningNumbers) {
        return lottos.compareWithWinLotto(winningNumbers);
    }

    public double calculateRevenue(List<Rank> ranks, Integer count) {
        return revenueCalculator.calculate(ranks, count);
    }
}
