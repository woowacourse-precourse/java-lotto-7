package lotto.model.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseMoneyTest {
	@DisplayName("구입 금액이 1,000원 미만일 경우 예외 발생")
	@Test
	void 구입금액이_천원미만이면_예외발생() {
		assertThatThrownBy(() -> new PurchaseMoney(500))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
	}

	@DisplayName("구입 금액이 1,000원 단위가 아닐 경우 예외 발생")
	@Test
	void 구입금액이_천원단위가_아니면_예외발생() {
		assertThatThrownBy(() -> new PurchaseMoney(2500))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
	}

	@DisplayName("구입 금액에 따른 로또 개수 확인")
	@Test
	void 구입금액에_따른_로또개수() {
		PurchaseMoney purchaseMoney = new PurchaseMoney(5000);
		assertThat(purchaseMoney.getLottoCount()).isEqualTo(5);
	}
}
