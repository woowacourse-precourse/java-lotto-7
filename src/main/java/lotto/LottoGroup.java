package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGroup {
    private final List<Lotto> lottos;

    public LottoGroup(List<Lotto> lottos) {
        this.lottos = List.copyOf(lottos);
    }

    public List<Prize> getPrizes(List<Integer> choices, int bonusNumber) {
        return lottos.stream()
                .map(each -> each.match(choices, bonusNumber))
                .filter(each -> each != Prize.NONE)
                .toList();
    }

    public int getTotalReward(List<Integer> choices, int bonusNumber) {
        return getPrizes(choices, bonusNumber).stream()
                .mapToInt(Prize::getReward)
                .sum();
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
