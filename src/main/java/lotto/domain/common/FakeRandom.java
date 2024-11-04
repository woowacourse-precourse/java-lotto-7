package lotto.domain.common;

import java.util.List;

public class FakeRandom implements Random {
	@Override
	public List<Integer> pickUniqueNumbersInRange(int startNumber, int endNumber, int count) {
		return List.of(1,2,3,4,5,6);
	}
}
