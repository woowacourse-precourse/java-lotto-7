package lotto.repository;

import java.util.List;
import lotto.model.Lotto;

public interface LottoRepository {
    void create(List<Integer> numbers);

    void save(Lotto lotto);
}
