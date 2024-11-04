package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lotto.domain.validator.ParamsValidator;

final public class LottoStatics {

    private final EnumMap<LottoPrize, Long> prizeCount;
    private final Money money;

    private LottoStatics(List<Lotto> lottos, WinningLotto winningLotto, Money money) {
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

    public static LottoStatics of(List<Lotto> lottos, WinningLotto winningLotto, Money money) {
        ParamsValidator.validateParamsNotNull(LottoStatics.class, lottos, winningLotto, money);

        return new LottoStatics(lottos, winningLotto, money);
    }

    public EnumMap<LottoPrize, Long> getPrizeCount() {
        return new EnumMap<>(this.prizeCount);
    }

    public float getIncomeRate() {
        return (float) calculateTotalIncome() / this.money.getAmount();
    }

    private long calculateTotalIncome() {
        return prizeCount.keySet().stream()
                .map(lottoPrize -> lottoPrize.prizeMoney * prizeCount.get(lottoPrize))
                .reduce(Long::sum)
                .orElse(0L);
    }
}
