package lotto.service;

import java.util.List;

import lotto.domain.WinNum;
import lotto.repository.WinNumRepository;
import lotto.repository.WinNumRepositoryImpl;

public class WinNumServiceImpl implements WinNumService {
	private static final WinNumService INSTANCE;
	private final WinNumRepository winNumRepository;
	
	static {
	    INSTANCE = new WinNumServiceImpl(WinNumRepositoryImpl.getInstance());
	}
	
	private WinNumServiceImpl(final WinNumRepository winNumRepository) {
		this.winNumRepository = winNumRepository;
	}

	public static WinNumService getInstance() {
		return INSTANCE;
	}

	@Override
	public void create(final List<Integer> numbers, final int bonusNumber) {
		WinNum winNum = WinNum.of(numbers, bonusNumber);
		winNumRepository.save(winNum);
	}

	@Override
	public WinNum get() {
		return winNumRepository.find();
	}
}
