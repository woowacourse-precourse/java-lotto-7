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

    // 테스트를 위한 리포지토리 초기화
    public void clear() {
        this.winningLotto = null;
    }
}
