package lotto.repository;

import java.math.BigInteger;
import lotto.model.Lotto;

public interface LottoRepository {

    void save(Lotto lotto);

    BigInteger count();
}
