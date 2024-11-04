package lotto.model.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReturnRateTest {
	@DisplayName("수익률 계산")
	@Test
	void 수익률_계산() {
		ReturnRate returnRate = new ReturnRate(8000, 5000);
		assertThat(returnRate.calculate()).isEqualTo(62.5);
	}
}
