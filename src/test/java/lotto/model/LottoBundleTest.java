package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBundleTest {

	@Test
	@DisplayName("구입 금액에 따라 로또 개수를 생성할 수 있다.")
	void 구입_금액에_따라_로또_개수를_생성한다() {
		// given
		LottoCreator lottoCreator = new LottoCreator();
		int lottoPrice = 1000;
		int count = 10;
		Price purchasePrice = new Price(lottoPrice * count);

		// when
		LottoBundle lottoBundle = new LottoBundle(purchasePrice, lottoCreator);

		// then
		assertEquals(count, lottoBundle.getLottos().size());
		assertEquals(count, lottoBundle.getCount());
	}
}