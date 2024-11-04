package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import java.util.List;

class LottoMachineTest {

	@Test
	void 로또_1등_수익률_확인() {
		List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
		int bonusNumber = 7;
		LottoMachine machine = new LottoMachine(winningNumbers, bonusNumber);

		List<Lotto> lottos = List.of(
				new Lotto(List.of(1, 2, 3, 4, 5, 6))
		);
		int money = lottos.size() * 1000;
		Result result = machine.check(lottos, money);

		double expectedPrizeRate = ((double) Prize.FIRST.getAmount() / money) * 100;
		assertThat(result.prizeRate()).isEqualTo(expectedPrizeRate);
	}
}
