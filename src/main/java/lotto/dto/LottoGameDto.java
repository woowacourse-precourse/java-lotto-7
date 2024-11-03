package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.PurchaseLottos;
import lotto.domain.WinningLotto;

import java.util.List;

public class LottoGameDto {
    private final List<Lotto> lottos;
    private final WinningLotto winningLotto;

    public LottoGameDto(PurchaseLottos purchaseLottos, WinningLotto winningLotto) {
        this.lottos = purchaseLottos.getLottos();
        this.winningLotto = winningLotto;
    }

    public List<Lotto> getLottos() {
        return lottos.stream().toList();
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }
}
