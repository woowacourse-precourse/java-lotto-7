package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

import lotto.domain.common.FakeRandom;

public class LottoMachineTest {

	@Test
	void 입력_금액_만큼_로또가_반환된다(){
		// given
		Money money = new Money(10000);
		FakeRandom fakeRandom = new FakeRandom();

		LottoMachine lottoMachine = new LottoMachine();

		// when
		List<Lotto> lottos = lottoMachine.purchaseLottos(money, fakeRandom);

		// then
		assertThat(lottos).hasSize(10);
		assertThat(lottos.get(0).getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
	}

	@Test
	void 입력_금액이_1000원_단위가_아닐_경우_예외가_발생한다(){
		// given
		Money money = new Money(10001);
		FakeRandom fakeRandom = new FakeRandom();

		LottoMachine lottoMachine = new LottoMachine();

		// when, then
		assertThatThrownBy(() -> lottoMachine.purchaseLottos(money, fakeRandom))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR] 1000원 단위로 입력할 수 있습니다.");
	}


}
