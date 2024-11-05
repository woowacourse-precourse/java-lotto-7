package lotto.util;

import static lotto.constants.LottoConstantNumbers.*;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
	public List<Integer> pickLottoNumbers() {
		return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue(),
			LOTTO_NUMBERS_COUNT.getValue());
	}
}
