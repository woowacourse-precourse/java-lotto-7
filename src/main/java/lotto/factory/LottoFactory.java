package lotto.factory;

import static lotto.model.domain.NumberConstant.MIN_RANGE_NUMBER;
import static lotto.model.domain.NumberConstant.MAX_RANGE_NUMBER;
import static lotto.model.domain.NumberConstant.NUMBER_COUNT;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.domain.Lotto;

public class LottoFactory {
	public static Lotto of() {
		List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER, NUMBER_COUNT);
		return Lotto.of(lottoNumbers);
	}
}
