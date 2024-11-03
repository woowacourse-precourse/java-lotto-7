package lotto.repository;

import java.math.BigInteger;
import java.util.List;
import lotto.model.Lotto;

public interface LottoRepository {

    void save(Lotto lotto);

    BigInteger count();

    List<Lotto> findAll();
}
