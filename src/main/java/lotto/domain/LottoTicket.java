package lotto.domain;

import lotto.constants.Ranking;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private final List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Ranking> checkRanking(WinningLotto winningLotto){
        return lottos.stream()
                .map(lotto -> lotto.checkRanking(winningLotto))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
