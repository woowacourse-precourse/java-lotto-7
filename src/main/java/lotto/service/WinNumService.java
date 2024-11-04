package lotto.service;

import java.util.List;

import lotto.domain.WinNum;

public interface WinNumService {
	void create(final List<Integer> numbers, final int bonusNumber);
	
	WinNum get();
}
