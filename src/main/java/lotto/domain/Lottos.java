package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.global.LottoRank;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<LottoRank> getWinningLottos(List<Integer> winningNumbers, int bonusNum) {
        return lottos.stream()
                .map(lotto -> lotto.checkWinningStatus(winningNumbers, bonusNum))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
