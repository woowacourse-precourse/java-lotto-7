package lotto.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MoneyTest {

	@Test
	void 금액이_양수가_아닌_경우_예외가_발생한다(){
		// given
		int amount = 0;

		// when, then
		Assertions.assertThatThrownBy(() -> new Money(amount))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR] 0원 이하는 입력할 수 없습니다.");

	}

	@Test
	void 금액을_입력하면_money_객체가_반환된다(){
		// given
		int amount = 5_000;

		// when
		Money money = new Money(amount);

		// then
		Assertions.assertThat(money).isNotNull();
		Assertions.assertThat(money.getAmount()).isEqualTo(5_000);
	}
}