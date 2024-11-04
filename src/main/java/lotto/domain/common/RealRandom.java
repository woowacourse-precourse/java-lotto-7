package lotto.domain.common;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RealRandom implements Random {
	@Override
	public List<Integer> pickUniqueNumbersInRange(int startNumber, int endNumber, int count) {
		return Randoms.pickUniqueNumbersInRange(startNumber, endNumber, count);
	}
}
