package lotto.util;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domains.lotto.constant.LottoNumberConstant;

public class LottoNumberGenerator {
	public static List<Integer> generateLottoNumbers() {
		return Randoms.pickUniqueNumbersInRange(LottoNumberConstant.LOTTO_MINIMUM_NUMBER,
			LottoNumberConstant.LOTTO_MAXIMUM_NUMBER, LottoNumberConstant.LOTTO_NUMBER_SIZE);
	}
}
