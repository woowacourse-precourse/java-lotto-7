package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	// 뽑는 횟수를 계산하는 함수
	public static int getCount(int payment) {
		return payment / 1000;
	}

	// 로또를 뽑는 함수
	public static List<Lotto> getLotto(int count) {
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
		}
		return lottos;
	}

	// 로또 번호 중에 보너스 번호가 존재하는지 확인하는 함수
	public static boolean isBonusMatch(List<Integer> lottos, int bonusNumber) {
		for (Integer num : lottos) {
			if (num == bonusNumber)
				return true;
		}
		return false;
	}

	// 로또 번호와 당첨번호를 비교하는 함수
	public static int compareNumbers(List<Integer> lottos, List<Integer> luckyNumber, int bonusNumber) {
		return (int)lottos.stream()
			.filter(luckyNumber::contains)
			.filter(num -> lottos.contains(bonusNumber))
			.count();
	}

	// 전체 수익을 계산하는 함수
	public static long calculateTotalEarningRate(List<Lotto> lottos, List<Integer> luckyNumber, int bonusNumber) {
		long total = 0;
		for (Lotto lotto : lottos) {
			List<Integer> numbers = lotto.getNumbers();
			int matchCount = compareNumbers(numbers, luckyNumber, bonusNumber);
			total += Prize.getPrize(matchCount, isBonusMatch(numbers, bonusNumber)).getReward();
		}
		return total;
	}

	// 수익률 계산하는 함수
	public static double calculateEarningRate(long total, int payment) {
		return (double) total / payment * 100;
	}

	public static void main(String[] args) {
		Input input = new Input();

		int payment = input.getPayment();
		int count = getCount(payment);

		List<Lotto> lottos = getLotto(count);
		List<Integer> luckyNumbers = input.getLuckyNumber();
		int bonusNumber = input.getBonusNumber(luckyNumbers);

		long total = calculateTotalEarningRate(lottos, luckyNumbers, bonusNumber);
		double earningRate = calculateEarningRate(total, payment);
	}
}
