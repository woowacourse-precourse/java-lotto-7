package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {
	private static final LottoRepository INSTANCE = new LottoRepository();
	private static final List<Lotto> repository = new ArrayList<>();

	private LottoRepository() {
	}

	public static LottoRepository getInstance() {
		return INSTANCE;
	}

	public Lotto save(Lotto lotto) {
		repository.add(lotto);
		return lotto;
	}

	public List<Lotto> findAll() {
		return repository;
	}

	public void clear() {
		repository.clear();
	}
}
