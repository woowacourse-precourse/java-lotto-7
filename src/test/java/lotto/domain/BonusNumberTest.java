package lotto.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

	@ParameterizedTest
	@ValueSource(ints = {0, 46})
	void 번호가_범위를_벗어나는_경우_예외가_발생한다(int number){
		// given

		// when, then
		Assertions.assertThatThrownBy(() -> new BonusNumber(number))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR] 로또 번호는 1~45 까지만 가능합니다.");
	}

	@Test
	void 번호를_입력하면_보너스_번호_객체가_반환된다(){
		// given
		int number = 3;

		// when
		BonusNumber bonusNumber = new BonusNumber(number);

		// then
		Assertions.assertThat(bonusNumber.getNumber()).isEqualTo(3);
	}
}