package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningLotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.constants.Constants.*;

public class LottoService {

	public List<Integer> generateLotto() {
		return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, REQUIRED_NUMBER_COUNT)
				.stream()
				.sorted()
				.collect(Collectors.toList());
	}

	public List<Lotto> generateLottoTickets(int count) {
		return IntStream.range(0, count)
				.mapToObj(i -> new Lotto(generateLotto()))
				.collect(Collectors.toList());
	}

	public LottoRank checkLottoRank(Lotto lotto, WinningLotto winningLotto) {
		return winningLotto.calculateRank(lotto);
	}
}
