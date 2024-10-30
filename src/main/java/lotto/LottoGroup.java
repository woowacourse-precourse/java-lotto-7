package lotto;

import java.util.List;

public class LottoGroup {
    private final List<Lotto> lottos;

    public LottoGroup(List<Lotto> lottos) {
        this.lottos = List.copyOf(lottos);
    }

    public List<Prize> getPrizes(List<Integer> choices, int bonusNumber) {
        return lottos.stream()
                .map(each -> each.match(choices, bonusNumber))
                .toList();
    }

    public int getTotalReward(List<Integer> choices, int bonusNumber) {
        return getPrizes(choices, bonusNumber).stream()
                .mapToInt(Prize::getReward)
                .sum();
    }
}
