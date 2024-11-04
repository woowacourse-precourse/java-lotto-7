package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

	@DisplayName("구매 금액을 생성할 수 있다.")
	@Test
	void from() {

		// given
		int purchaseAmount = 7000;

		// when
		PurchaseAmount testPurchaseAmount = PurchaseAmount.from(purchaseAmount);

		// then
		assertThat(testPurchaseAmount.getPurchaseAmount()).isEqualTo(purchaseAmount);
	}

	@DisplayName("구매 금액으로 자연수만 혀용한다.")
	@ValueSource(ints = {-1000, -1, 0})
	@ParameterizedTest(name = "{0}은 구매금액으로 허용하지 않는다.")
	void fromWithoutNaturalNumber(int purchaseAmount) {

		// when // then
		assertThatThrownBy(() -> PurchaseAmount.from(purchaseAmount))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@DisplayName("구매 금액은 로또 금액 단위만 혀용한다.")
	@Test
	void fromWithLottoPriceUnit() {

		// given
		int purchaseAmount = 2001;

		// when // then
		assertThatThrownBy(() -> PurchaseAmount.from(purchaseAmount))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@DisplayName("구매한 로또 개수를 조회할 수 있다.")
	@Test
	void getPurchaseLottoCount() {

		// given
		int purchaseAmount = 12000;
		PurchaseAmount testPurchaseAmount = PurchaseAmount.from(purchaseAmount);

		// when
		int purchaseLottoCount = testPurchaseAmount.getPurchaseLottoCount();

		// then
		assertThat(purchaseLottoCount).isEqualTo(12);

	}

}