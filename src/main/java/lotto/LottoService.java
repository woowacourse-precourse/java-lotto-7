package lotto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {
    private final LottoGenerator lottoGenerator;

    public LottoService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Lottos createLottos(Integer count) {
        return new Lottos(
                IntStream.range(0, count)
                        .mapToObj(i -> lottoGenerator.createLotto())
                        .collect(Collectors.toList()));
    }

    public double calculateRevenue(List<Rank> ranks, Integer count) {
        long total = 0L;
        for (Rank rank : ranks) {
            total += rank.calculate(1);
        }
        return Math.round((total / (double)count * 100) * 10)/10.0;
    }
}
