package lotto.model.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.factory.LottoFactory;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoBundle;

public class LottoService {
	private static final int MIN_RANGE_COUNT = 0;

	public LottoBundle createLottoBundle(int count) {
		List<Lotto> lottoList = IntStream.range(MIN_RANGE_COUNT, count)
			.mapToObj(i -> LottoFactory.of())
			.collect(Collectors.toList());

		return LottoBundle.of(lottoList);
	}
}
