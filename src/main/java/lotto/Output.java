package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Output {
	public void init() {
		System.out.println("구입금액을 입력해 주세요.");
	}

	public void printLottoCount(int lottoCount) {
		System.out.println(lottoCount + "개를 구매했습니다.");
	}

	public void printLottos(List<Lotto> lottos) {
		lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
		System.out.println();
	}

	public void printLuckyNumber() {
		System.out.println("당첨 번호를 입력해 주세요.");
	}

	public void printBonusNumber() {
		System.out.println("보너스 번호를 입력해 주세요.");
	}

	public void printResult(List<Lotto> numbers, List<Integer> luckyNumber, int bonusNumber) {
		LottoGame lottoGame = new LottoGame();
		System.out.println("당첨 통계\n---");

		Map<Prize, Integer> rankCount = new EnumMap<>(Prize.class);
		for (Prize prize : Prize.values()){
			rankCount.put(prize, 0);
		}

		for (Lotto lotto : numbers) {
			int matchCount = lottoGame.getMatchCount(lotto.getNumbers(), luckyNumber, bonusNumber);
			boolean isBonusMatch = lottoGame.isBonusMatch(lotto.getNumbers(), bonusNumber);

			Prize prize = Prize.getPrize(matchCount, isBonusMatch);
			rankCount.put(prize, rankCount.get(prize) + 1);
		}

		rankCount.forEach((rank, count) -> {
			if (rank != Prize.LOSE){
				System.out.printf("%s %d개%n",
					rank.getMessage(), count);
			}
		});
	}

	public void printEarningRate(double earningRate) {
		System.out.printf("총 수익률은 %.1f%%입니다.%n", earningRate);;
	}

}