package lotto.service;

import java.math.BigDecimal;

import lotto.domain.PrizeStat;

public interface PrizeStatService {
	void create();
	
	PrizeStat get();
	
	BigDecimal calculateEarningsRate(final int lottoCount);
}
