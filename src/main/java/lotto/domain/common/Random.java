package lotto.domain.common;

import java.util.List;

public interface Random {

	List<Integer> pickUniqueNumbersInRange(int startNumber, int endNumber, int count);
}
