package lotto.service;

import java.math.BigInteger;
import java.util.List;

import lotto.domain.Lotto;

public interface LottoService {
	void createAll(BigInteger purchaseAmount);
	
	List<Lotto> getAll();
}
