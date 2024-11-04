package lotto.repository;

import lotto.domain.WinNum;

public class WinNumRepositoryImpl implements WinNumRepository {
	private static final WinNumRepository INSTANCE;
	private WinNum winNum;
	
	static {
		INSTANCE = new WinNumRepositoryImpl();
	}
	
	private WinNumRepositoryImpl() {}
	
	public static WinNumRepository getInstance() {
		return INSTANCE;
	}
	
	@Override
	public void save(final WinNum winNum) {
		this.winNum = winNum;
	}

	@Override
	public WinNum find() {
		return winNum;
	}
}
