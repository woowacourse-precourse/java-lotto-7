package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lotto.model.Lottos;

public class LottosTest {

	private Lottos lottos = new Lottos();

	@Test
	void 구입금액의_문자열이_숫자가_아니면_예외가_발생한다() {
		assertThatThrownBy(() -> lottos.calculateNumberOfLotto("abc"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 구입금액의_숫자가_1000으로_나누어_떨어지지_않으면_예외가_발생한다() {
		assertThatThrownBy(() -> lottos.calculateNumberOfLotto("12345"))
			.isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> lottos.calculateNumberOfLotto("123"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 구매한_로또_개수를_계산한다() {
		assertThat(lottos.calculateNumberOfLotto("9000"))
			.isEqualTo(9);
	}
}
