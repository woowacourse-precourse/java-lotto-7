package lotto.model.lottoBuyer;

import lotto.model.lotto.Lotto;

import java.util.List;

public interface LottoRepository {

    void saveLotto(Lotto lotto);
    List<Lotto> findAllLotto();
}
