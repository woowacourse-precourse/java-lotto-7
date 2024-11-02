package lotto.repository;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {

    private static final LottoRepository lottoRepository = new LottoRepository();
    private final List<Lotto> lottos = new ArrayList<>();

    private LottoRepository() {

    }

    public static LottoRepository getInstance() {
        return lottoRepository;
    }

    public void save(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> findAll() {
        return lottos;
    }
}
