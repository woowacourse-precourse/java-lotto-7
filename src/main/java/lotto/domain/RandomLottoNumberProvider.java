package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomLottoNumberProvider {

	public List<List<Integer>> provideBy(int purchaseLottoCount) {
		return Stream.generate(() -> {
				List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
					LottoInfo.MAX_NUMBER.getInfo(),
					LottoInfo.MIN_NUMBER.getInfo(),
					LottoInfo.SIZE.getInfo()
				));
				Collections.sort(randomNumbers);
				return randomNumbers;
			})
			.limit(purchaseLottoCount)
			.toList();
	}
}
