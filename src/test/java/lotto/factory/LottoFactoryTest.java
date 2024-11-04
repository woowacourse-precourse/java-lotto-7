package lotto.factory;

import lotto.model.domain.Lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {
	@DisplayName("로또 번호가 6개이며, 범위 내에서 생성되는지 테스트")
	@Test
	void 로또_생성_테스트() {
		Lotto lotto = LottoFactory.of();

		assertThat(lotto.getNumbers()).hasSize(6);
		assertThat(lotto.getNumbers()).allMatch(number -> number >= 1 && number <= 45);
	}
}
