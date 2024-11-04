package lotto.view;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.PrizeStat;

public interface ApplicationView {
	BigInteger requestPurchaseAmount();
	
	void printLottoNumbers(List<Lotto> lottos);
	
	List<Integer> requestWinningNumbers();
	
	int requestBonusNumber(List<Integer> winningNumbers);
	
	void printWinningStatistics(PrizeStat prizeStat, BigDecimal earningsRate);
}
