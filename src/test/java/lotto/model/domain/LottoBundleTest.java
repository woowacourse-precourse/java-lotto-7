package lotto.model.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBundleTest {

	@DisplayName("LottoBundle이 정상적으로 생성되는지 테스트")
	@Test
	void 로또_번들_생성_테스트() {
		List<Lotto> lottoList = List.of(
			new Lotto(List.of(1, 2, 3, 4, 5, 6)),
			new Lotto(List.of(7, 8, 9, 10, 11, 12))
		);

		LottoBundle lottoBundle = LottoBundle.of(lottoList);

		assertThat(lottoBundle.lottoBundle()).isEqualTo(lottoList);
	}
}
