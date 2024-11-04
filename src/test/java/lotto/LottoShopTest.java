package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoShopTest {
	private static final int LOTTO_UNIT = 1000;

	@Test
	void 금액에_맞는_로또_개수_확인() {
		LottoShop shop = new LottoShop();
		int money = 15000;
		int quantity = money / LOTTO_UNIT;

		int lottoCount = shop.sell(money).size();
		assertThat(lottoCount).isEqualTo(quantity);
	}
}
