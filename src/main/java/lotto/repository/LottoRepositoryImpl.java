package lotto.repository;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;

public class LottoRepositoryImpl implements LottoRepository {
	private static final LottoRepository INSTANCE;
	private final List<Lotto> lottos = new ArrayList<>();
	
	static {
		INSTANCE = new LottoRepositoryImpl();
	}
	
	private LottoRepositoryImpl() {};
	
	public static LottoRepository getInstance() {
		return INSTANCE;
	}
	
	@Override
	public void saveAll(final List<Lotto> lottos) {
		this.lottos.addAll(lottos);
	}

	@Override
	public List<Lotto> findAll() {
		return lottos;
	}
}
