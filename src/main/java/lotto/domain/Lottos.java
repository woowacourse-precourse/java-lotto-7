package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.global.LottoRank;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lotto) {
        this.lottos = lotto;
    }

    public List<LottoRank> getWinningLottos(List<Integer> winningNumbers, int bonusNum) {
        return lottos.stream()
                .map(lotto -> lotto.checkWinningStatus(winningNumbers, bonusNum))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
