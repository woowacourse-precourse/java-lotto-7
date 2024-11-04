package lotto.repository;

import lotto.domain.PrizeStat;

public class PrizeStatRepositoryImpl implements PrizeStatRepository {
	private static final PrizeStatRepository INSTANCE;
	private PrizeStat prizeStat;
	
	static {
		INSTANCE = new PrizeStatRepositoryImpl();
	}
	
	private PrizeStatRepositoryImpl() {}
	
	public static PrizeStatRepository getInstance() {
		return INSTANCE;
	}
	
	@Override
	public void save(final PrizeStat prizeStat) {
		this.prizeStat = prizeStat;
	}

	@Override
	public PrizeStat find() {
		return prizeStat;
	}
}
