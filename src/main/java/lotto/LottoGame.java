package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGame {
	public int getLottoCount(int payment) {
		return payment / 1000;
	}

	public List<Lotto> getLotto(int lottoCount) {
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < lottoCount; i++) {
			lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
		}
		return lottos;
	}

	public int getMatchCount(List<Integer> lottos, List<Integer> luckyNumber, int bonusNumber) {
		return (int) lottos.stream()
			.filter(num -> luckyNumber.stream()
				.anyMatch(i -> i == num) || num == bonusNumber)
			.count();
	}

	public boolean isBonusMatch(List<Integer> lottos, int bonusNumber) {
		for (Integer num : lottos) {
			if (num == bonusNumber) {
				return true;
			}
		}
		return false;
	}

	public double calculateEarningRate(long total, int payment) {
		return (double) total / payment * 100;
	}

	public long calculateTotalEarningRate(List<Lotto> lottos, List<Integer> luckyNumber, int bonusNumber) {
		long total = 0;
		for(Lotto lotto : lottos) {
			List<Integer> numbers = lotto.getNumbers();
			int matchCount = getMatchCount(numbers, luckyNumber, bonusNumber);
			total += Prize.getPrize(matchCount, isBonusMatch(numbers, bonusNumber)).getReward();
		}
		return total;
	}
}
