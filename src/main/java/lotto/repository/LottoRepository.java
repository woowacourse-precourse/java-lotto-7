package lotto.repository;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {
    private static List<Lotto> lottos;
    private static LottoRepository instance;

    private LottoRepository() {
        lottos = new ArrayList<>();
    }

    public static LottoRepository getInstance() {
        if (instance == null) {
            instance = new LottoRepository();
        }
        return instance;
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> findAll() {
        return lottos;
    }

}
