package lotto.repository;

import lotto.domain.Lotto;

public class LottoRepositoryImpl implements LottoRepository {

    private Lotto winningLotto;

    public Lotto save(Lotto lotto) {
        this.winningLotto = lotto;
        return winningLotto;
    }

    public Lotto findWinningNums() {
        return winningLotto;
    }

}
