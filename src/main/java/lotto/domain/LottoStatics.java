package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

final public class LottoStatics {

    private final EnumMap<LottoPrize, Long> prizeCount;
    private final Money money;

    public LottoStatics(List<Lotto> lottos, WinningLotto winningLotto, Money money) {
        this.prizeCount = calculatePrizeCount(lottos, winningLotto);
        this.money = money;
    }

    private static EnumMap<LottoPrize, Long> calculatePrizeCount(
            final List<Lotto> lottos,
            final WinningLotto winningLotto
    ) {
        EnumMap<LottoPrize, Long> prizeCount = lottos.stream()
                .map(winningLotto::matchLotto)
                .flatMap(Optional::stream)
                .collect(Collectors.groupingBy(
                        rank -> rank,
                        () -> new EnumMap<>(LottoPrize.class),
                        Collectors.counting()
                ));

        Arrays.stream(LottoPrize.values())
                .forEach(prize -> prizeCount.putIfAbsent(prize, 0L));

        return prizeCount;
    }

    public EnumMap<LottoPrize, Long> getPrizeCount() {
        return new EnumMap<>(this.prizeCount);
    }
}
